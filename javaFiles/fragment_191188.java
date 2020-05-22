//Creates list of all available sums. Sorts them and passes to calculate
 public static int solution(int[][] a, int K, int n) {

    List<Sum> sums = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        int rowSum = 0;
        int colSum = 0;
        for (int j = 0; j < n; j++) {
            rowSum += a[i][j];
            colSum += a[j][i];
        }
        sums.add(new Sum(rowSum, true, i));
        sums.add(new Sum(colSum, false, i));
    }
    Collections.sort(sums);
    return calculate(sums, K, n, 0);
}

public static int calculate(List<Sum> sums, int K, int n, int res) {

    //if (K < 50) System.out.println(K);
    int result = res;
    for (int i = 0; i < K; i++) {
        Collections.sort(sums);
        Sum chosenSum;
        if (sums.get(0).currentSum == sums.get(1).currentSum && K > 1) {
            long low = sums.get(0).currentSum;

            int colCount = 0;
            int rowCount = 0;
            Sum rows = null;
            Sum cols = null;
            for (Sum s : sums) {
                if (s.currentSum == low) {
                    if (s.isRow) {
                        rowCount++;
                        if (rows == null) {
                            rows = s;
                        }
                    } else {
                        colCount++;
                        if (cols == null) {
                            cols = s;
                        }
                    }
                }
            }
            if (colCount == 0) {
                chosenSum = rows;
            } else if (rowCount == 0) {
                chosenSum = cols;
            } else {
                chosenSum = (calculate(copySums(sums), K - i, n, new Sum(rows)) < calculate(copySums(sums), K - i, n, new Sum(cols)) ? rows : cols);
            }
        } else {
            chosenSum = sums.get(0);
        }

        result += chosenSum.currentSum;
        chosenSum.currentSum += n;
        for (Sum s : sums) {
            if (chosenSum.isRow ^ s.isRow) {
                s.currentSum++;
            }
        }
        Collections.sort(sums);
    }

    return result;
}

public static int calculate(List<Sum> sums, int K, int n, Sum chosenSum) {

    for (Sum s : sums) {
        if (chosenSum.isRow ^ s.isRow) {
            s.currentSum++;
        }
        if (s.isRow == chosenSum.isRow && s.index == chosenSum.index) {
            s.currentSum += n;
        }
    }
    Collections.sort(sums);

    return calculate(copySums(sums), K, n, (int) chosenSum.currentSum);
}

public static List<Sum> copySums(List<Sum> sums) {
    ArrayList<Sum> result = new ArrayList<>();
    for (Sum s : sums) {
        result.add(new Sum(s));
    }
    return result;
}