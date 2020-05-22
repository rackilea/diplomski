for(Object key: orr.keySet()) {

                JSONArray orderOne = (JSONArray)orr.get(key);
                JSONObject ordervalue = (JSONObject)orderOne.get(0);
                System.out.println(ordervalue.get("productId"));
        }