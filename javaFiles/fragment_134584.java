import java.util.ArrayList;
import java.util.List;

public class Huge {

    private static final int NUMBER_OF_VECTORS = 250;
    private static final int VECTOR_SIZE = 10000;

    //Size: 19,2 MB Classes: 328 Objects: 2,7k 
    public static void doulbeArray() {

        double[][] structure = new double[NUMBER_OF_VECTORS][];

        for(int i = 0; i < NUMBER_OF_VECTORS; i++) {
            structure[i] = new double[VECTOR_SIZE];
        }
    }

    //Size: 76,5 MB Classes: 332 Objects: 2,5m
    public static void doubleWrapperArray() {

        Double[][] structure = new Double[NUMBER_OF_VECTORS][];

        for(int i = 0; i < NUMBER_OF_VECTORS; i++) {
            structure[i] = new Double[VECTOR_SIZE];
            for (int k = 0; k < VECTOR_SIZE; k++) {
                structure[i][k] = Double.valueOf(Math.random());
            }
        }
    }

    //Size: 79,6 MB Classes: 330 Objects: 2,5m 
    public static void list() {

        List<List<Double>> structure = new ArrayList<List<Double>>(); 

        for(int i = 0; i < NUMBER_OF_VECTORS; i++) {
            List<Double> vector = new ArrayList<Double>();            
            for (int k = 0; k < VECTOR_SIZE; k++) {
                vector.add(Double.valueOf(Math.random()));
            }
            structure.add(vector);
        }
    }
}