public static void main (String[] args) throws Exception {
    String[] firstList = { "Merchant", "Peasant", "Queen" };
    String[] secondList = { "King", "Queen", "Knight", "Merchant", "Peasant" };

    for (String highRank : secondList) {
        for (String lowRank : firstList) {
            if (highRank.equalsIgnoreCase(lowRank)) {
                System.out.println(highRank);
                return;
            }
        }
    }
}