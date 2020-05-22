resultList = new ArrayList<HashMap<String, String>>(predsJsonArray.lengtgh());
for (int i = 0; i < predsJsonArray.length();, i++) {
     HashMap<String, String> place = new HashMap<String, String>();
     String description = predsJsonArray.getJSONObject(i).getString("description");
     String placeId = predsJsonArray.getJSONObject(i).getString("place_id");
     place.put("description", description);
     place.put("place_id", placeId);
     resultList.add(place);
}