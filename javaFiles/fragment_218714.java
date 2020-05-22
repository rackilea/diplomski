String encrypt (String input) {
    String result;
    for (int i = input.length() - 1
            ; i >= 0
            ; --i) {
        result += input[i];
        if (i > 0) {
            append "diff" number of random character to result
        }
    }
    return result;
}