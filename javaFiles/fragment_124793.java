public void getUser() {
    // if you put a json object to the server
    // the properties are automagically mapped to the methods' input parameters
    JSONObject param = new JSONObject();
    param.put("name", "John Doe");
    param.put("age", 47);


        JSONObject result = sendJsonRequest("server", 80, 
              "http://server:80/service1.asmx/GetUser", param);
        if (result != null) {
            JSONObject user = new JSONObject(result.getString("d"));
            // .net webservices always return the result
            // wrapped in a parameter named "d"
            system.out.println(user.getString("name"));
            system.out.println(user.getInt("age").toString());
        }
}