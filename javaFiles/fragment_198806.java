Scanner scan - new Scanner(file);
int row = scan.nextInt();
int col = scan.nextInt();
int[][] graph = new int[row][col];
for(int r=0; r<row; r++) {
   for(int c=0; c<col; c++) {
      graph[r][c] = scan.nextInt();

  }
}