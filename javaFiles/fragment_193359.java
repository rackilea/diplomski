import java.util.Scanner;

public class CC {

    int c, f, l, m;

    int returnCount(int i, int j) {
        int smaller = Math.min(i, j);
        int bigger = Math.max(i, j);

        f = 0;
        for (int k = smaller; k <= bigger; k++) {
            l = k;
            c = 0;
            while (l > 1) {
                if (l % 2 == 0) {
                    l = l / 2;
                    c++;
                } else {
                    l = 3 * l + 1;
                    c++;
                }

            }
            if (f < c)
                f = ++c;
        }
        return f;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, j;
        CC obj = new CC();
        while (sc.hasNextInt()) {
            i = sc.nextInt();
            j = sc.nextInt();
            System.out.println(i + " " + j + " " + obj.returnCount(i, j));
        }
    }

}