ArrayList<HashMap<String, String>> AL_route_bus_collection_a = new    ArrayList<HashMap<String,String>>();

for(int i = 0;i<routeNo_set.size();i++ ) {

    HashMap<String,String>  HM_route_bus_collection_a  = new HashMap<String, String>();
    HM_route_bus_collection_a.put("route_no", routeNo_set.get(i));
    HM_route_bus_collection_a.put("address", address_set.get(i));
    HM_route_bus_collection_a.put("bus_type", busType_set.get(i));

    AL_route_bus_collection_a.add(HM_route_bus_collection_a);
}
for (HashMap<String, String> hashMap : AL_route_bus_collection_a) {
    System.out.println(hashMap.keySet());
    for (String key : hashMap.keySet()) {
        System.out.println(hashMap.get(key));
    }
}