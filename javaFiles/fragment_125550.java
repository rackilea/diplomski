try
        {
            JSONObject j = new JSONObject("your json response");
            JSONArray all = j.getJSONArray("all");
            for (int i = 0; i < all.length(); i++)
            {
                JSONObject data = all.getJSONObject(i);
                System.out.println("title       =>"+data.getString("title"));
                JSONArray maps = data.getJSONArray("maps");
                for (int k = 0; k < maps.length(); k++)
                {
                    JSONObject data_sec = maps.getJSONObject(k);
                    System.out.println("name        => "+data_sec.getString("name"));
                    System.out.println("latitude    => "+data_sec.getString("latitude"));
                    System.out.println("longitude   => "+data_sec.getString("longitude"));

                }


            }
        }
        catch (Exception e)
        {
            // TODO: handle exception
        }