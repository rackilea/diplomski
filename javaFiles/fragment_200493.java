List<LstObj> lstArr = Arrays.asList(
    new LstObj("0:0:1", "1:0:1", 49),
    new LstObj("0:0:2", "1:0:2", 2),
    new LstObj("0:2:1", "1:2:1", 0),
    new LstObj("0:2:2", null , 0),
    new LstObj("0:2:3", "1:2:3" , 2),
    new LstObj("0:2:4", "1:2:4" , 49),
    new LstObj("1:0:1", "0:0:1" , 49),
    new LstObj("1:0:2", "0:0:2" , 49),
    new LstObj("1:2:1", "0:2:1" , 0),
    new LstObj("1:2:2", null , 0),
    new LstObj("1:2:3", "0:2:3" , 49),
    new LstObj("1:2:4", "0:2:4" , 49)
);

Function<LstObj,Object> groupFunc = o -> {
    String id = o.getId(), partId = o.getPartId();
    return partId == null? Void.TYPE: partId.compareTo(id)<0? partId: id;
};
List<LstObj> result = lstArr.stream()
        .sorted(Comparator.comparing(LstObj::getPartId, Comparator.nullsLast(null))
                          .thenComparingInt(LstObj::getCount))
        .collect(Collectors.groupingBy(groupFunc, LinkedHashMap::new, Collectors.toList()))
        .values().stream()
        .flatMap(List::stream)
        .collect(Collectors.toList());
System.out.println(result);