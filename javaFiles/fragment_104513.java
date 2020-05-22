public static int add(Integer... numbers) {
    int result = 0;
    for (Integer number : numbers) {
        result += number;
    }
    return result;
}