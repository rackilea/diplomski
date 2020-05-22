public class SubsetSum {
    public static void main(String[] args) {
        int [] array = { 1, 2, 3, 4 };
        hasSum(array, 4);
    }

    public static boolean hasSum(int [] array, int sum) {
        int len = array.length;
        boolean[][] table = new boolean[sum+1][len+1];
        for(int i = 0; i <= len; i++) table[0][i] = true;
        for(int i = 1; i <= sum; i++) table[i][0] = false;
        for(int i = 1; i <= sum; i++) {
            for(int j = 1; j <= len; j++) {
                table[i][j] = table[i][j-1];
                if(!table[i][j] && i >= array[j-1]) {
                    table[i][j] = table[i-array[j-1]][j-1];
                }
            }
        }

        System.out.printf("%10s ", "-");
        for(int i = 0; i <= sum; i++) {
            System.out.printf("%10s ", i);
        }
        System.out.println();
        for(int j = 0; j <= len; j++) {
            System.out.printf("%10s ", j);
            for(int i = 0; i <= sum; i++) {
                System.out.printf("%10s ", table[i][j]);
            }
            System.out.println();
        }

        return table[sum][len];
    }
}