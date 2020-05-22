String str= "{\"bitrate\":false,\"bitrateInit\":40000,\"bitr\":10000}";
        String str2= "{\"enable\":true }";

        JSONObject jObj = new JSONObject(str);
        jObj.put("test", new JSONObject(str2));
        System.out.println(jObj);