public static void main(String[] s1) throws Exception {
    int gameboard[][] = new int[4][4];
    Set<Integer> mySet = new HashSet<>();

    for (int row = 0; row < gameboard.length; row++) {
        for (int col = 0; col < gameboard[row].length; col++) {
            int randNum = (int) (1 + Math.random() * 16);

            while (mySet.contains(randNum)) {
                randNum = (int) (1 + Math.random() * 16);
            }
            mySet.add(randNum);

            gameboard[row][col] = randNum;
            System.out.printf("%-4d", gameboard[row][col]);
        }
        System.out.println();
    }
}