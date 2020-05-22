public void putToMap(String name) {
    String firstLetter = name.substring(0, 1);

    List<String> names = testMap.get(firstLetter);
    if (names == null) {
        names = new LinkedList<String> ();
        testMap.put(firstLetter, names);
    }

    names.add(name);
}