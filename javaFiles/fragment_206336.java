if (predsJsonArray.getJSONObject(i).has("rating")){

            // here it is safe to use predsJsonArray.getJSONObject(i).getDouble("rating")

    Restaurant restaurant = new Restaurant(
       predsJsonArray.getJSONObject(i).getString("reference"),
       predsJsonArray.getJSONObject(i).getString("name"),
       predsJsonArray.getJSONObject(i).getString("vicinity"),
       predsJsonArray.getJSONObject(i).getString("icon"),
       predsJsonArray.getJSONObject(i).getDouble("rating"));
    resultList.add(restaurant);
        }