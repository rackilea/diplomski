import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    static ArrayList<Double> routedClients = new ArrayList<Double>();

    public static void main(String[] args) {
        double[][] arr1 = { { 2, 4, 6 }, { 3, 6, 9 }, { 5, 10, 15 } };
        routedClients.add(new Double(1));
        routedClients.add(new Double(2));
        routedClients.add(new Double(3));

        print(arr1);
        double[][] arr2 = removeSite(arr1);
        print(arr2);
    }

    private static void print(double[][] arr1) {
        for (int i = 0; i < arr1.length; i++) {
            double[] arr2 = arr1[i];
            for (int j = 0; j < arr2.length; j++) {
                System.out.println("arr1[" + i + "][" + j + "] = " + arr1[i][j]);
            }
        }
    }


    public static double[][] removeSite(double[][] array) {

        List<double[]> stockout = new ArrayList<double[]>(Arrays.asList(array));
        System.out.println("length before = " + stockout.size());

        for (int i = array.length-1; i >= 0; i--) {
            for (int j = 0; j < routedClients.size(); j++) {
                if (array[i][0] == routedClients.get(j)) {
                    System.out.println("removing " + routedClients.get(j));
                    stockout.remove(i);
                }
            }
        }
        double[][] remainingStockout = (double[][]) stockout.toArray(new double[][] {});
        System.out.println("length after = " + remainingStockout.length);
        return remainingStockout;
    }

}