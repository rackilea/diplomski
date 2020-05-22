public static int score(String pw) {
    int score = 1; // <-- 1 to 5...
    if (containsUpperCase(pw)) {
        score++;
    }
    if (containsLowerCase(pw)) {
        score++;
    }
    if (containsDigit(pw)) {
        score++;
    }
    if (containsSpecial(pw)) {
        score++;
    }
    return score;
}