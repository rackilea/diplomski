JSONObject data= new JSONObject();

            data.accumulate("username", "mobileGps");
            data.accumulate("password", "9565551236");

            JSONObject total= new JSONObject();
            total.put("data",data);

            json = jsonObjectNew.toString();