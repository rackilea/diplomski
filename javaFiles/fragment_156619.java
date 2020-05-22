public void sendData(List<?> objectIds) {
    List<Integer> converted = new ArrayList<Integer>();

    for (Object objectId : objectIds) {
        converted.add(((Number)objectId).intValue());
    }
    ...
}