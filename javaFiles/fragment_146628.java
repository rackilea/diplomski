public class Alphy {

    private double[][] x;

    public Alphy (double[][] x) {
        this.x = x;
    }

    public double[][] multiplyWith (double[][] y) {
        int nr = x.length, nc = x[0].length;
        double[][] z = new double[nr][nc];

        for (int i = 0 ; i < nr ; i++)
            for (int j = 0 ; j < nc ; j++)
                z[i][j] = x[i][j] * y[j][i];
        return z;
    }

    public static void print (double[][] m, String label) {
        int nr = m.length, nc = m[0].length;
        System.out.println (label);
        for (int i = 0 ; i < nr ; i++) {
            for (int j = 0 ; j < nc ; j++)
                System.out.print ("\t" + m[i][j]);
            System.out.println();
    }}

    public static void main (String[] args) {
        double[][]  X = {{4, 9}, {8, 7}, {3, 2}, {9, 1}},
                Y = {{4, 11, 12, 14}, {13, 9, 22, 7}},
                Z = new Alphy(X).multiplyWith(Y);
        Alphy.print (X, "Initial Matrix");
        Alphy.print (Y, "Multiplied by");
        Alphy.print (Z, "Gives the result");
}}
/* Output of the above class:

Initial Matrix
    4.0 9.0
    8.0 7.0
    3.0 2.0
    9.0 1.0
Multiplied by
    4.0 11.0    12.0    14.0
    13.0    9.0 22.0    7.0
Gives the result
    16.0    117.0
    88.0    63.0
    36.0    44.0
    126.0   7.0
*/