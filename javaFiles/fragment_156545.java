import java.util.Arrays;
public class Algoritme4 {
public static void main(String[] args) {
    algo2D(new int[][]{
            {2, 1, -3, -4, 5},
            {0, 6, 3, 4, 1},
            {2, -2, -1, 4, -5},
            {-3, 3, 1, 0, 3}
    });
}

private static int[] algo4(int[] a) {
    int maxEndingHere = 0;
    int i;
    int[] result = {0, 0, 0};
    for (i = 0; i < a.length; i++) {
        if (maxEndingHere + a[i] > 0) {
            maxEndingHere += a[i];
        } else {
            maxEndingHere = 0;
            result[1] = i + 1;
        }
        if (result[0] < maxEndingHere) {
            result[0] = maxEndingHere;
            result[2] = i;
        }
    }
    System.out.println("Max sum of sub matrix = " + result[0] + " (" + result[1] + "," + result[2] + ")");
    return result;
}
private static void algo2D(int[][] a){
    int[] result = {0,0,0};
    int maxSoFar = 0;
    int maxR = 0;
    int maxL = 0;
    int start = 0;
    int slut = 0;
    int L;
    int R;
    int k;

    for (L = 0; L<a.length; L++) {
        int[] temp = {0,0,0,0};
        for (R = L; R < a[0].length; R++){
            System.out.println("R = " + R);
            System.out.println("L = " + L);
            for (k = 0; k < a.length; k++) {
                temp[k] += a[k][R];
                if (k==3) {
                    System.out.println("temp = " + Arrays.toString(temp));
                    result = algo4(temp);
                }
                if (result[0]> maxSoFar){
                    maxSoFar = result[0];
                    maxL = L;
                    maxR = R;
                    start = result[1];
                    slut = result[2];
                }

            }

        }
    }
    System.out.println("Max: " + maxSoFar + " (" + maxL + "," + start + ") (" + maxR + "," + slut + ")");
}