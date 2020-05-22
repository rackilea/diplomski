public static void main(String... args) {
    Map<String, Set<Double>> map = new HashMap<>();
    map.put("HR3-A1234", valSetOne(null)); // first element is min
    map.put("HR3-A2345", valSetTwo(Collections.reverseOrder()));  // first element is max
    map.put("HR3-A3456", valSetThree(null)); // first element is min
    map.put("HR3-A4567", valSetFour(null)); // first element is min

    map.forEach((key, values) -> {
        if (values != null && !values.isEmpty())
            System.out.format("Value of %s is %.2f\n", key, values.iterator().next());
    });
}

private static Set<Double> valSetOne(Comparator<Double> comparator) {
    Set<Double> values = new TreeSet<>(comparator);
    values.add(.0);
    values.add(.01);
    values.add(1.);
    return values;
}

private static Set<Double> valSetTwo(Comparator<Double> comparator) {
    Set<Double> values = new TreeSet<>(comparator);
    values.add(.0);
    values.add(.01);
    return values;
}

private static Set<Double> valSetThree(Comparator<Double> comparator) {
    Set<Double> values = new TreeSet<>(comparator);
    values.add(.01);
    values.add(1.);
    return values;
}

private static Set<Double> valSetFour(Comparator<Double> comparator) {
    Set<Double> values = new TreeSet<>(comparator);
    values.add(.01);
    return values;
}