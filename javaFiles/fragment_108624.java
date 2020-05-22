private OpwaardernId getOpwaardernId(String opId) {
    // store all value in a map
    Map<String, String> map = Map.of("ID001", "xxx", "ID002", "123", ..);
    // then just call 
    return map.containsKey(opId) ? opwaardernId.of(map.get(opId)) : null;
}