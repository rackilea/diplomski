public static ArrayList<Integer> getCollumnSum() {
        int[][] data = {{3, 2, 5},
                        {1, 4, 4, 8, 13},
                        {9, 1, 0, 2},
                        {0, 2, 6, 3, -1, -8}};
        int col = 0;
        ArrayList<Integer> totals = new ArrayList<Integer>();
        while (true) {
          int total = 0;
          boolean dataInCol = false;
          for (int i = 0; i < data.length; i++) {
            if (col < data[i].length) {
                total += data[i][col];
                dataInCol = true;
            }
          }
          col += 1;
          if (dataInCol) {
            totals.add(total);
          } else {
            break;
          }
        }
        return totals;
      }