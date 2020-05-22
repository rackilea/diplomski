boolean first = false;
boolean second= false;
boolean third = false;
List<Integer> loadList = new ArrayList<>(3);
if ((dstIp.toString().equals("10.0.0.1") && udp.getPayload() != null) {
    loadList.add(0, intLoad1);
    first = true;
} else if ((dstIp.toString().equals("10.0.0.2") && udp.getPayload() != null) {
    loadList.add(1, intLoad2);
    second = true;
} else if ((dstIp.toString().equals("10.0.0.3") && udp.getPayload() != null) {
    loadList.add(2, intLoad3);
    third = true;
}

if (!loadList.isEmpty() && !loadList.contains(null) && first && second && third) {
    int sum = loadList.stream().mapToInt(Integer::intValue).sum();
    System.out.println("---- Sum: "+sum);
    double averageLoad = ((double) sum) / loadList.size();
    first = false;
    second= false;
    third = false;
}