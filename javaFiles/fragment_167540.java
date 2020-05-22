public static int countAllLetters(String[] array) {
    int sum = 0;
    for(String s : array)
        sum += s.length();
    return sum;
}