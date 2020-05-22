public class Robot4 {

static int nCurrRow = 1;
static int nCurrCol = 1;
static long R = 0;
static Set<Long> cell;
static long N;

public static void main(String[] args) throws IOException {

    Reader.init(System.in);

    int i = 0;
    int n = Reader.nextInt();
    int k = Reader.nextInt();

    // Add a border around the matrix with values of 1
    N = n + 2L;
    cell = new HashSet<Long>(1000000);

    for (i = 0; i < N; i++) {
        set(0, i);
        set(i, 0);
        set(i, n+1);
        set(n+1, i);
    }
    set(nCurrRow, nCurrCol);

    R = (long)n * n - 1; // Number of remaining unvisited cells

    int sec1 = Reader.nextInt();
    int sec2 = 0;
    String dir1 = Reader.next();
    String dir2 = "";

    for (i = 0; i < k - 1; i++) {

        sec2 = Reader.nextInt();
        dir2 = Reader.next();
        move(sec2-sec1, dir1);
        dir1 = dir2;
        sec1 = sec2;

    }
    move(n, dir1);

    System.out.println(R);

}

static void move(int t, String dir1) {
    boolean canMove = true;
    int xDir = 0;
    int yDir = 0;
    if (dir1.equals("SE")) {
        xDir = 1;
        yDir = 1;
    } else if (dir1.equals("NE")) {
        xDir = 1;
        yDir = -1;
    } else if (dir1.equals("E")) {
        xDir = 1;
    } else if (dir1.equals("N")) {
        yDir = -1;
    } else if (dir1.equals("NW")) {
        xDir = -1;
        yDir = -1;
    } else if (dir1.equals("W")) {
        xDir = -1;
    } else if (dir1.equals("SW")) {
        xDir = -1;
        yDir = 1;
    } else if (dir1.equals("S")) {
        yDir = 1;
    }
    for (int j = 0; j < t && canMove; j++) {
        if (!isSet(nCurrRow + yDir, nCurrCol + xDir)) {
            nCurrRow += yDir;
            nCurrCol += xDir;
            set(nCurrRow, nCurrCol);
            R--;
        } else
            canMove = false;
    }
}

static boolean isSet(int x, int y) {
    return cell.contains(indexId(x,y));
}
static void set(int x, int y) {
    cell.add(indexId(x,y));
}
static long indexId(int x, int y) {
    return x*N+y;
}

static class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(
                     new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    /** get next word */
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            tokenizer = new StringTokenizer(
                   reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
}
}