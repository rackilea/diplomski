int[][] gameboard = new int[4][4];
ArrayList<Integer> used = new ArrayList<Integer>();
int emptySlot = (int) (1 + Math.random() * 16);

for(int row = 0; row < gameboard.length; row++) {
    for(int col = 0; col < gameboard[row].length; col++) {
        if(row*gameboard.length + col == emptySlot) {
            System.out.print("    ");
            continue; //skip empty slot
        }
        int number;
        while(used.contains(number = (int) (1 + Math.random() * 15)));
        used.add(number);
        gameboard[row][col] = number;
        System.out.printf("%-4d",gameboard[row][col]);
      }
    System.out.println();
}