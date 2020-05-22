Map<String, DataWise> map = new HashMap<String, DataWise>();
...
DataWise wise = map.get(name);
if (wise != null) {
    wise.incrementVisits();
}
else {
    wise = new DataWise(name, 1);
    map.put(name, wise);
}