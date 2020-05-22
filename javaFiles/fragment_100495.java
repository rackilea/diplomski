MultivaluedMap params = new MultivaluedMapImpl();
params.add("username", "username");

String response = webResource
                .type("application/x-www-form-urlencoded")
                .post(String.class, params);