static void set(boolean[][] paths, int cols, int row0, int col0, int row1, int col1) {
     int index0 = row0 * cols + col0;
     int index1 = row1 * cols + col1;
     paths[index0][index1] = paths[index1][index0]= true;
 }

 static boolean[][] paths(String[] maze) {
     int rows = maze.length;
     int cols = maze[0].length();
     boolean[][] paths = new boolean[rows * cols][rows * cols];
     for (int i = 0; i < rows; ++i) {
         for (int j = 0; j < cols; ++j) {
             if (maze[i].charAt(j) == 'X')
                 continue;
             if (i + 1 < rows && maze[i + 1].charAt(j) != 'X')
                 set(paths, cols, i, j, i + 1, j);
             if (j + 1 < cols && maze[i].charAt(j + 1) != 'X')
                 set(paths, cols, i, j, i, j + 1);
         }
     }
     return paths;
 }

 public static void main(String[] args) {
     String[] maze = {
         "XXXOOOOX",
         "OXXXOXOE",
         "OXXOOXXO",
         "OSXOXXXO",
         "XOOOXOOO",
     };
     boolean[][] paths = paths(maze);
     for (boolean[] row : paths) {
         for (boolean cell : row)
             System.out.print(cell ? "1" : "0");
         System.out.println();
     }
 }