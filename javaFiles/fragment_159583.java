TreeMap<String, ArrayList<Double>> map = new TreeMap<>();
    while (dataSource.hasNext()) {
        String state = dataSource.next();
        Double d = Double.parseDouble(dataSource.next());
        map.computeIfAbsent(state, k -> new ArrayList<>()).add(d);
    }
    return map;