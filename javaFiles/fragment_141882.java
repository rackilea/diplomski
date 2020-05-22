InputStreamReader reader = new InputStreamReader(input);
JSONParser parser = new JSONParser();
response = parser.parseJSON(reader);

List listResponses = (List) response.get("root");
if (listResponse != null) {
    for (Object listResponse : listResponses) {
        Map tempHash = (Map) listResponse;
        hi.addComponent(new Label("Name: " + tempHash.get("name").toString())); 
        hi.addComponent(new Label("Surname: " + tempHash.get("surname").toString())); 
        System.out.println(tempHash.get("name").toString()); //Print abc
        System.out.println(tempHash.get("surname").toString()); //Print xyz
    }
    hi.getComponentForm().revalidate();
} else {
    System.out.println("null value returned"); //Make sure you reference root and be sure it returns proper json
}