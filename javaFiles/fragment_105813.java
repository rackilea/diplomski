public String toString(int[] arr) {
    StringBuilder result = new StringBuilder();
    result.append("[");
    for (int a : arr) {
        result.append(a);
    }
    result.append("]");
    return result.toString();
}