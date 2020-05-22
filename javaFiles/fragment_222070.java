JSONArray manufacturerArray = new JSONArray();
HashMap<String, JSONArray> manufacturerMap = new HashMap<String, JSONArray>();

while(rs.next()) {
    String mId = rs.getString("manufacturer_id");
    JSONArray carsArray = manufacturerMap.get(mId);
    if (carsArray == null) {
        carsArray = new JSONArray();
        manufacturerMap.put(mId, carsArray);
    }
    JSONObject manufacturer = new JSONObject();                         
    manufacturer.put("id", mId);
    manufacturer.put("name", rs.getString("manufacturer_name"));                  

    String carId = rs.getString("id");                    
    String carName = rs.getString("name");
    String carPrice = rs.getString("price");
    carsArray.put(getCarJSON(carId, carName, carPrice));

    manufacturer.put("cars", carsArray);
    manufacturerArray.put(manufacturer);
}
JSONObject result = new JSONObject();
result.put("manufacturers", manufacturerArray);