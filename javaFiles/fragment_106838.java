static String findValueStream(List<DataStructure> list, String key) {
    return list.stream() // initial Stream<DataStructure>
            .filter(ds -> key.equals(ds.getKey())) // filtered Stream<DataStructure>
            .map(DataStructure::getValue) // mapped Stream<String>
            .findFirst() // first Optional<String>
            .orElse(null); // or else return 'null'
}