try {
            JSONObject object = new JSONObject(jsonString);
            JSONObject myObject = object.getJSONObject("recentlyMarkedTerritories");

            for (int i = 0; i < object.length(); i++) {
                JSONObject myObject2 = myObject.getJSONObject(Integer.toString(i));
                System.out.println(myObject2.toString(2));  
            }
        } catch (Exception e) {
            e.printStackTrace();
        }