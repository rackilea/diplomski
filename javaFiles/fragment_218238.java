public static boolean contains(String[] array, String key) {

        Objects.requireNonNull(array,"The array must not be null");
        Objects.requireNonNull(array,"The key must not be null");

        String[] copy = array.clone();
        Arrays.sort(copy);

        return Arrays.binarySearch(copy, key) != -1;
    }