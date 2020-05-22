HttpClient client = HttpClients.createDefault();
    HttpGet request = new HttpGet(jsonUrl);

    try {
        HttpResponse response = client.execute(request);
        HttpEntity entity = response.getEntity();
        if(entity != null){
            //Allows me to search through the Participant Object using the 
            //Participant/Participants POJO
            Gson gson = new GsonBuilder().
                    registerTypeAdapter(ParticipantWrapper.class, new MyDeserializer<>()).
                    create();
            ContentType contentType = ContentType.getOrDefault(entity);
            Charset charset = contentType.getCharset();
            Reader reader = new InputStreamReader(entity.getContent(), charset);

            /*Goes through seperate JSON files received from the Challonge API.
            */
            ArrayList<Participant> al = new ArrayList<>();

            JsonParser jsonParser = new JsonParser();
            JsonElement jsonElement = jsonParser.parse(reader);


           if(jsonElement.isJsonArray()){
               Iterator itor = jsonElement.getAsJsonArray().iterator();

               while(itor.hasNext()){
                   JsonObject jObject = (JsonObject) itor.next();
                   al.add(gson.fromJson(jObject.get("participant"), Participant.class));
               }
           }
            return al;
        }
    } catch (IOException ex) {
        Logger.getLogger(TournamentInfo.class.getName()).log(Level.SEVERE, null, ex);
        return null;
    }