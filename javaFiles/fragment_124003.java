Map<Object, List<TravelRequestDTO>> hashMap = new HashMap<Object, List<TravelRequestDTO>>();
for (TravelRequestDTO value: initList) {
    List<Object> key = Arrays.asList(value.getOnWard(),value.getReturn(),value.getLeavingFrom(),value.getGoingTo());
    if (!hashMap.containsKey(key)) {
        List<TravelRequestDTO> list = new ArrayList<TravelRequestDTO>();
        list.add(value);
        hashMap.put(key, list);
    } else {
        hashMap.get(key).add(value);
    }
}