Map<Object, TravelRequestDTO> hashMap = new HashMap<Object, TravelRequestDTO>();
for (TravelRequestDTO value: initList) {
    List<Object> key = Arrays.asList(value.getOnWard(),value.getReturn(),value.getLeavingFrom(),value.getGoingTo());
    if (!hashMap.containsKey(key)) {
        TravelRequestDTO item = value; // pass first value or copy it to new
        hashMap.put(key, item);
    } else {
        hashMap.get(key).getPassangers().addAll(value.getPassangers());
    }
}
List<TravelRequestDTO> result = new ArrayList<>(hashMap.values());