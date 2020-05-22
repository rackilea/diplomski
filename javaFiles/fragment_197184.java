public static Pair<String,Double> getMinimumKeyValue(
    Map<String, List<Double>> map, Comparator<Double> function) {

    return map.entrySet().stream()
        .map(e->new Pair<>(e.getKey(), e.getValue().stream().min(function).get()))
        .min(Comparator.comparing(Pair::getRight, function)).get();
}