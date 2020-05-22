JSONObject reader = new JSONObject(val.toString());

        String email = (String)reader.get("email"));
        String name = (String)reader.get("name"));

        reader = new JSONObject(valVerify.toString());
        boolean verified = reader.getBoolean("email_verified"));