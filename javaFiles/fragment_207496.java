Map<Car, List<String>> namesByCar = new HashMap<Car, List<String>>();
for (Map.Entry<String, Car> entry : preferences) {
    String name = entry.getKey();
    Car car = entry.getValue();
    List<String> names = namesByCar.get(car);
    if (names == null) {
        names = new ArrayList<String>();
        namesByCar.put(car, names);
    }
    names.add(name);
}