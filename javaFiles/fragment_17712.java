public static String Tickets(int[] peopleInLine) {
    int d25 = 0, d50 = 0;
    for (int aPeopleInLine : peopleInLine) {
        if (aPeopleInLine == 25){
            d25++;
        }
        if (aPeopleInLine == 50) {
            d25--;
            d50++;
        }
        if (aPeopleInLine == 100) {
            if (d50 > 0) {
                d50--;
                d25--;
            } else {
                d25 -= 3;
            }
        }
        if (d25 < 0){
            return "NO";
        }
    }
    return "YES";
}