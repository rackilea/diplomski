try {
            JSONObject responseObject = new JSONObject(response);
            String A= responseObject.getString("A");
            JSONArray bArray= responseObject.getJSONArray("B");
            for(int i=0;i<bArray.length();i++){
                JSONObject innerObject=bArray.getJSONObject(i);
                String a= innerObject.getString("a");
                String b= innerObject.getString("b");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }