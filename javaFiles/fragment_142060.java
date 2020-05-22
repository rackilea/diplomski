public class Mymainclass implements Runnable {
    static int n;

    // a and b are input matrix's
    static int a[][];
    static int b[][];
    /* we will multiply the elements in a and b matrix's
    * parallely by using two threads
    and will store in the c matrix sequentially.*/
    static int c[][];

    public Mymainclass(int n1) {
        n = n1;
        a = new int[n][n];
        b = new int[n][n];
        c = new int[n][n];
    }

    public void run() {
        int i, j, k;

        System.out.println("in thread1 class");

        for (i = 0; i < this.n; i++) {
            for (j = 0; j < n; j++) {
                for (k = 0; k < n; k++) {
                    this.c[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        System.out.print("\n");
        System.out.println("Matrix c in thread1");
        for (int a = 0; a < n; a++) {
            for (int b = 0; b < n; b++) {
                System.out.print(c[a][b] + " ");
            }
            System.out.print("\n");
        }
    }

    static int N = 4 ;
    public static void main(String[] args) {

        Mymainclass th1 = new Mymainclass(N);

        int z = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = z++;
            }
            System.out.print("\n");
        }

        z = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                b[i][j] = z++;
            }
            System.out.print("\n");

        }


        System.out.println("Matrix a");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.print("\n");
        }

        System.out.print("\n");
        System.out.println("Matrix b");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.print("\n");

        }

        System.out.print("\n");


        Thread t = new Thread(th1);
        t.start();
    }

}