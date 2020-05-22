public void someMethod(Object value) {
    float[] array = (float[]) value;
    List<Float> result = new ArrayList<Float>(array.length);
    for (float f : array) {
        result.add(Float.valueOf(f));
    }
    // ...
}