public  void increaseRow(Integer row) {
        synchronized (rows.get(row)) {
            for (int j = 0; j < column; j++) {
                matrix[row][j] += 1;
                System.out.print(String.format("row %s value %s",row,matrix[row][j]));
            }
        }
   }