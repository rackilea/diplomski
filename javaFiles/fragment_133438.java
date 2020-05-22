Client client = ClientBuilder.newClient();
    {
        String url = "http://jerseyexample-ravikant.rhcloud.com/rest/jws/getObj/list";
        System.out.println(url);
        Response response = client.target(url).request().get();
        ObjectMapper ob = new ObjectMapper();

        Object pojos = response.readEntity(Object.class);
        System.out.println(pojos.getClass());
         if(pojos instanceof java.util.ArrayList){
            ArrayList<User> list =  (ArrayList) pojos;

            for (Object pojo : list) {
                User user = ob.convertValue(pojo, User.class);
                System.out.println(user.getName());
            }
        }else{
            System.out.println("user");
            User user = ob.convertValue(pojos, User.class);
        }
        //System.out.println(response);

    }