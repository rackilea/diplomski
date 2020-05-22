for(int i = 0; i < items.length(); i++)
            {

                 JSONObject values  = items.getJSONObject(i);
                   String name= values.getString("name");
                    System.out.println(name+"          nameee");
                //artist array
                JSONArray artists = album.getJSONArray("artists");
  }