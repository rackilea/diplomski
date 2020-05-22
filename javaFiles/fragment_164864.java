JSONObject obj;
            try {
                obj =new JSONObject();
                obj.put("alert","oman expert ");
                obj.put("action","Your Package name.UPDATE_STATUS");



data.put("from", ParseUser.getCurrentUser().getUsername());         


    obj.put("msg","hi");
    obj.put("title","msg");
                ParsePush push = new ParsePush();
                ParseQuery query = ParseInstallation.getQuery();



                push.setQuery(query);
                push.setData(obj);
                push.sendInBackground(); 
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }