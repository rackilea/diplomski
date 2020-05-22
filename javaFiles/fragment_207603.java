private boolean moreThanFourSelected(input) {
    String days[] = { "mon", "tues", ..., "sun" };
    int total = 0;
    for (String day : days) {
        if (input.contains(day)) total++;
    }
    return total >= 4;
}