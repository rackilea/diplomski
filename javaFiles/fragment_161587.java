public static List<Office> rearrange2(List<Office> source, String... locations) {
    Map<String, List<Office>> map = source.stream().collect(Collectors.toMap(
            Office::getLocation,
            o -> {List<Office> lst = new ArrayList<>(); lst.add(o); return lst;},
            (offices, offices2) -> {offices.addAll(offices2); return offices;}));
    return Arrays.asList(locations).stream()
            .filter(map::containsKey)
            .map(map::get)
            .flatMap(Collection::stream)
            .collect(Collectors.toList());
}