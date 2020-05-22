list.put("guest_login");
        try {
            obj.put("chips", new JSONObject().put("1", "2000"));
            obj.put("invested", new JSONObject().put("1", "2000"));
            obj.put("login_id", "10");
            JSONArray news = new JSONArray();
            news.put("Welcome to Poker.");
            news.put("Register and get started with 2000 play chips.");
            obj.put("news", news);   
            obj.put("username","Guest10");
            obj.put("epoch", "119677");
            list.put(obj);
        } catch (JSONException e) {
            e.printStackTrace();
        }