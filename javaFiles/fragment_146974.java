for (int i = 0; i < jsonArrayFrench.length(); i++) {
            JSONArray innerJsonArray = jsonArrayFrench.getJSONArray(i);
            for (int j=0; j < innerJsonArray.length(); j++)
            {
                JSONObject jsonObject = innerJsonArray.getJSONObject(j);
                if(jsonObject.getString("category").equals(category))
                    subnewsFrench.add(jsonObject.getString("title"));
            }   
}