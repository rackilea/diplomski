import java.util.Arrays;
import java.util.List;

public class MAD {

    public static void main(String[] args) {
        List<Double> input = Arrays.asList(new Double[] {1d, 1d, 2d, 2d, 4d, 6d, 9d});
        System.out.println(mad(input));
    }

    private static Double mad(List<Double> inputList) {
        Double[] input = inputList.toArray(new Double[inputList.size()]);
        Double median = median(input);
        arrayAbsDistance(input, median);
        return median(input);

    }

    private static void arrayAbsDistance(Double[] array, Double value) {
        for (int i=0; i<array.length;i++) {
            array[i] = Math.abs(array[i] - value);
        }
    }

    private static Double median(Double[] input) {
        if (input.length==0) {
            throw new IllegalArgumentException("to calculate median we need at least 1 element");
        }
        Arrays.sort(input);
        if (input.length%2==0) {
            return (input[input.length/2-1] + input[input.length/2])/2;
        } 
        return input[input.length/2];
    }
}