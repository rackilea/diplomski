JSONObject mainObject = new JSONObject(strjson);

      JSONArray Array = mainObject.getJSONArray("speciality");
        for (int j = 0; j < Array.length(); j++) 
        {   
            if (Array.getJSONObject(j).has("id")) 
            {
                String str1 = (Array.getJSONObject(j).getString("id"));
                String str2 = (Array.getJSONObject(j).getString("d_name"));
              Log.e("TA","name:"+str2);
             }
        }