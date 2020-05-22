public static <T> boolean hasDuplicates(List<T> list, T element) {
    int count = 0;
    for (T other: list) {
        // Ugly, but necessary to ensure null-safety
        boolean areEquals = (other == null)? element == null : other.equals(element);
        if (areEquals) {
            count += 1;
            if (count > 1) {
                return true;
            }
        }
    }
    return false;
}