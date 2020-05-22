List<Integer> myList = IntStream.range(1, 17).boxed().collect(Collectors.toList());
Collections.shuffle(myList);

for (int row = 0; row < gameboard.length; row++) {
    for (int col = 0; col < gameboard[row].length; col++) {
        gameboard[row][col] = myList.get(row * gameboard.length + col);
        System.out.printf("%-4d", gameboard[row][col]);
    }
    System.out.println();
}