private static double average(Map.Entry<String, List<MyObject>> entry, ToDoubleFunction<MyObject> getter) {
    return average(entry.getValue(), getter);
}

private static double average(List<MyObject> list, ToDoubleFunction<MyObject> getter) {
    return list.stream().mapToDouble(getter).average().orElse(0);
}