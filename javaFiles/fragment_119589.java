Map<Double, ArrayList<Integer>> mapResult = db.detectRoute(latD, longD);
Iterator<Map.Entry<Double, ArrayList<Integer>>> it = mapResult.entrySet().iterator();
while (it.hasNext()) {
    Map.Entry<Double, ArrayList<Integer>>> e =  it.next();
    Double distance = entry.getKey();
    ArrayList<Integer> value = entry.getValue();
}