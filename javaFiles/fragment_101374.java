public static boolean containsFourOfaKind(int hand[]) {
    for (int i = 0; i < hand.length; i++) {
        int countOfKind = 0;
        for (int j = 0; j < hand.length; j++) {
            if (hand[i] == hand[j]) {
                countOfKind++;
            }
        }
        if (countOfKind >= 4) {
            return true;
        }
    }
    return false;
}