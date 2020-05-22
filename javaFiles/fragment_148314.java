//Go over the map using RX and print the entries to csv
Observable.from(map.entrySet()).subscribe(entry -> {
    StringJoiner csvJoiner = new StringJoiner("\",\"", "\"", "\"");
    csvJoiner.add(entry.getKey());
    Observable.from(entry.getValue()).subscribe(price -> csvJoiner.add(Double.toString(price)));
    System.out.println(csvJoiner.toString());
});