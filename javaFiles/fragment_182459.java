static String[] generate(int start, int stop) {
    String strnew[] = new String[stop - start + 1];
    for (int i = 0; i < strnew.length; i++) {
        int value = start + i;
        if (value % 15 == 0) {
            strnew[i] = "FizzBuzz";
        } else if (value % 3 == 0) {
            strnew[i] = "Fizz";
        } else if (value % 5 == 0) {
            strnew[i] = "Buzz";
        } else {
            strnew[i] = String.valueOf(value);
        }
    }
    return strnew;
}