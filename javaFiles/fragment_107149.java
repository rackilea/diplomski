private static void addValuesFromList(List<?> arr, StringJoiner joiner) {
    StringJoiner spaceJoiner = new StringJoiner(" ");

    for (int i = 0; i < arr.size(); i++) {
        Object value = arr.get(i);
        spaceJoiner.add(String.valueOf(value));
    }
    String spacedValue = spaceJoiner.toString(); 
    addValue(spacedValue, joiner);

}