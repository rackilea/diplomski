int n = Integer.parseInt(lines[0]); 
int[][] matrix = new int[n][n];
for (int j = 1; j <= n; j++) {
                String[] currentLine = lines[j].split(" ");
                for (int i = 0; i < currentLine.length; i++) {
                    matrix[j-1][i] = Integer.parseInt(currentLine[i]);
                }
}