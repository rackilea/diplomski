// This is used as both the accumulator and combiner,
// since MyObject is both the element type and result type
BiConsumer<MyObject, MyObject> reducer = (o1, o2) -> {
    o1.setValue(o1.getValue() + o2.getValue());
    o1.setLength(o1.getLength() + o2.getLength());
    o1.setTemperature(o1.getTemperature() + o2.getTemperature());
}
MyObject totals = list.stream()
        .collect(() -> new MyObject(0, 0d, 0f), reducer, reducer);