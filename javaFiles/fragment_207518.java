int[][] array = new int[number][number];

for (int i = 0; i < number; i++){
    for (int j = 0; j < number; j++){
        if (i == j || i == number - 1 - j) {
            array[i][j] = 1;
        }
        System.out.print(array[i][j] + " ");
    }
    System.out.print("\n");
}