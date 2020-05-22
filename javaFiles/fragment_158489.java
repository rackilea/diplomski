public class Test {

public static void main(String[] args) throws Exception {
   solve();
}

public static void solve() throws Exception {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int testcases = Integer.parseInt(reader.readLine());

    int i = 0;
    for (i = 0; i < testcases; ++i) {
        int n = Integer.parseInt(reader.readLine());
        int[][] result ;

        result = parseInput(reader, n);

        System.out.println("####");
        for(int j=0;j<n;++j){
            for(int k=0;k<n;++k){
                System.out.print(result[j][k] + " ");
            }
            System.out.println();
        }
        System.out.println("####");
    }
}

public static int[][] parseInput(BufferedReader reader, int n) throws Exception {

    int[][] result = new int[n][n];

    String line;
    int i = 0;
    for (i = 0; i < n; ++i) {
        line = reader.readLine();
        for (int j = 0; j < n; j++) {
            result[i][j] = line.charAt(j);
        }
    }

    return result;
}
}