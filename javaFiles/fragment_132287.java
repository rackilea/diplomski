public static <T> T[] fillWithRepeat(int length, T... elements) {

    List<T> output = new ArrayList<>(Arrays.asList(elements));
    for(int i = 0; i < length - elements.length; i++){
        output.add(elements[elements.length - 1]);
    }

    return output.toArray(elements);
}