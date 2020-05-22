HttpEntity ent= resp.getEntity();


            text = EntityUtils.toString(ent);

            JSONObject json = new JSONObject(text);

            int success= -1;
            if(json.has("success"))
                success = json.getInt("success");

            if (success == 1){
                Log.v("JSON" ,"es 1");
            }