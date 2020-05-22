JSONArray jsonArray=new JSONArray(data);
            if(jsonArray!=null && jsonArray.length()>0){
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONArray childJsonArray=jsonArray.optJSONArray(i);
                    if(childJsonArray!=null && childJsonArray.length()>0){
                        for (int j = 0; j < childJsonArray.length(); j++) {
                            System.out.println(childJsonArray.optString(j));
                        }
                    }
                }
            }