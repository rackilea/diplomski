private List<Unit> nearestUnits(List<Unit> lists, Unit x, int limit) {
    TreeMap<Double, Unit> sorted = new TreeMap<>();
    List<Unit> output = new ArrayList<>();
    for (Unit unit : lists) {
        Double distance = calculateDistance(unit, x);
        sorted.put(distance, unit);
    }
    Set<Double> keys = sorted.keySet();
    Iterator<Double> iter = keys.iterator();
    int count = 0;
    while (iter.hasNext() && count < limit) {
        Double key = iter.next();
        Unit val = sorted.get(key);
        output.add(val);
        count++;
    }
    return output;
}