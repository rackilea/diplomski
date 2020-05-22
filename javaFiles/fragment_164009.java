int sumChars(String charStr) {
    int sum = 0;
    for (int i = 0; i < charStr.length(); i++) {
        sum += (charStr.charAt(i) - 'A') + 1;
    }
    return sum;
}