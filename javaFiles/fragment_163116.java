int input = scanner.nextInt();
int[][] adjMatrix = new int[8][8];

for(int i=0; i < input; i++) {
    for (int j=0; j < input; j++) {
         adjMatrix[i][j] = scanner.nextInt();
    }
}