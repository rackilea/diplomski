array = (String[][]) Arrays.asList(array).stream()
                            // Filters out empty arrays
                            .filter(checkEmptyArrays())
                            // Filters out empty strings
                            .map(x -> cleanUpEmptyStrings(x))
                            // Collects it all back into the array matrix
                            .collect(Collectors.toList()).toArray(new String[0][0]);


private String[] cleanUpEmptyStrings(String[] x) {
    return Arrays.asList(x).stream().filter(y -> y != null && !y.equals("")).collect(Collectors.toList()).toArray(new String[0]);
}

private Predicate<String[]> checkEmptyArrays() {
    return k -> Arrays.stream(k).filter(l -> l != null && !l.equals("")).count() != 0;
}