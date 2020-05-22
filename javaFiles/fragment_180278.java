Scanner s = new Scanner(System.in);
int size = Integer.parseInt(s.nextLine());
int[][] tablero = new int[size][size];
boolean exit = false;
while (!exit) {
    for (int i = 0; i < size; i++) {
        String valuesStrArr[] = s.nextLine().split(",");
        for (int j = 0; j < size; j++) {
            tablero[i][j] = Integer.parseInt(valuesStrArr[j]);
        }

        if (i == size - 1)
            exit = true;
    }
}