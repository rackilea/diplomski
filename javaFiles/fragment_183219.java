public  void increaseRow(Integer row) {
    synchronized (rows.get(row)) {
        for (int j = 0; j < column; j++) {
            matrix[row][j] += 1;
        }
        System.out.println(String.format("begin update row %s", row));
        for (int i = 0; i < this.row; i++) {
            System.out.println();
            for (int j = 0; j < column; j++)
                System.out.print(String.format("row %s value %s",row,matrix[i][j]));
        }
        System.out.println();
        System.out.println("String.format("end update row %s", row)");
    }