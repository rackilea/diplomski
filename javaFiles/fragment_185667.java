private static void print() {
    for (String[][] bank : questionBanks) {
        System.out.println("==============");
        for (String[] row : bank) {
            System.out.println("------------");
            for (String el : row) {
                System.out.print(el);
                System.out.print("\t");
            }
            System.out.println("\n");
        }
    }
}