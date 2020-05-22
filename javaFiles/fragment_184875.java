private void findData() {

   ArrayList<String> dataArrayList=new ArrayList<>();

try {

    JSONParser parser = new JSONParser();
    InputStream in = getClass().getResourceAsStream("/json/Services.json");
    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
    Object obj = parser.parse(reader);
    JSONObject jsonObject = (JSONObject) obj;

    JSONArray msg = (JSONArray) jsonObject.get("Service1");
    Iterator<JSONObject> iterator = msg.iterator();

    while (iterator.hasNext()) {
        JSONObject jsonObjectData = iterator.next();
        JSONObject dataObject = (JSONObject) jsonObjectData.get("data");
        System.out.println(dataObject); 
        //Extract values 
  dataObject.values().stream().forEach(value->{
                    System.out.println(value);
     dataArrayList.add(value.toString());

                });
    }

} catch (IOException | org.json.simple.parser.ParseException ex) {
    Logger.getLogger(CorporationRegistrationFormController.class.getName()).log(Level.SEVERE, null, ex);
}

}