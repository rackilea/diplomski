@Scheduled(fixedDelay=60000)
    public void ApiExpirationTask()
    {
        // Beginning of the ApiKeyExpirationJob Workflow
        List<Api> apiList = apiService.findAll();

        for(Api api1 : apiList) {
            //logger.info(api.getApiKey());
            //final SimpleDateFormat df = new SimpleDateFormat( "dd/MM/yyyy HH:mm:ss" );
            final java.util.Calendar cal = GregorianCalendar.getInstance();
            cal.setTime( api1.getCreatedDate() );
            cal.add( GregorianCalendar.MINUTE, 1 ); // date manipulation
            Date dateExpectedExpiryDate = cal.getTime();
            Date dateNow = new Date();
            if ((dateNow.compareTo(dateExpectedExpiryDate) >= 0) && (api1.getIsExpired() == false))
            {
                api1.setIsExpired(true);

                try {
                    //TODO: Fix apache commons logging to work with SLF4J. Then remove the out.println statements.
                    //logger.info("Updating API");
                    System.out.println("Updating API");
                    apiService.update(api1);


                    //post the entity as JSON
                    String postUrl=api1.getUrl();// put in your url
                    Gson gson= new Gson();
                    HttpPost post = new HttpPost(postUrl);
                    StringEntity  postingString = new StringEntity(gson.toJson(api1));//convert your pojo to   json
                    //logger.info("API Entity in json representaton is: " + gson.toJson(api1));
                    System.out.println("API Entity in json representaton is: " + gson.toJson(api1));
                    //logger.info(postingString.toString());
                    post.setEntity(postingString);
                    post.setHeader("Content-type", "application/json");
                    @SuppressWarnings("deprecation")
                    HttpClient httpClient = new DefaultHttpClient();
                    HttpResponse  response = httpClient.execute(post);
                    //logger.info(response.getStatusLine().toString());
                    System.out.println(response.getStatusLine().toString());
                } catch (IOException | ApiNotFound e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        //End of ApiKeyExpirationJob Workflow