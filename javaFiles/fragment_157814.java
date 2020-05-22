private static String[] recurFizzBuzz(String[] result, int index,
        int start, int end) {
    if (index > result.length) {
        return result;
    }
    if (index % 15 == 0) {
        result[index - 1] = "FizzBuzz";
    } else if (index % 3 == 0) {
        result[index - 1] = "Fizz";
    } else if (index % 5 == 0) {
        result[index - 1] = "Buzz";
    } else {
        result[index - 1] = Integer.toString(index);
    }
    return recurFizzBuzz(result, index + 1, start, end);
}