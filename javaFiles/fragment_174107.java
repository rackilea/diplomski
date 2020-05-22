import java.lang.reflect.Array;
import java.util.*;

public class Test {

    public static int[] tail(int[] arr) {
        return Arrays.copyOfRange(arr, 1, arr.length);
    }

    public static void setValue(Object array, String value, int... indecies) {
        if (indecies.length == 1)
            ((String[]) array)[indecies[0]] = value;
        else
            setValue(Array.get(array, indecies[0]), value, tail(indecies));
    }

    public static void fillWithSomeValues(Object array, String v, int... sizes) {
        for (int i = 0; i < sizes[0]; i++)
            if (sizes.length == 1)
                ((String[]) array)[i] = v + i;
            else
                fillWithSomeValues(Array.get(array, i), v + i, tail(sizes));
    }

    public static void main(String[] args) {

        // Randomly choose number of dimensions (1, 2 or 3) at runtime.
        Random r = new Random();
        int dims = 1 + r.nextInt(3);

        // Randomly choose array lengths (1, 2 or 3) at runtime.
        int[] sizes = new int[dims];
        for (int i = 0; i < sizes.length; i++)
            sizes[i] = 1 + r.nextInt(3);

        // Create array
        System.out.println("Creating array with dimensions / sizes: " +
                Arrays.toString(sizes).replaceAll(", ", "]["));
        Object multiDimArray = Array.newInstance(String.class, sizes);

        // Fill with some 
        fillWithSomeValues(multiDimArray, "pos ", sizes);

        System.out.println(Arrays.deepToString((Object[]) multiDimArray));


    }
}