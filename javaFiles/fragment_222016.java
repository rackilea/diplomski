import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class X {

    public String quickSortArray(String numbers, String indexNumber) throws NumberFormatException, Exception{

        String[] data = numbers.split(";");
        int index = parseInt(indexNumber);
        int[] inputNum = new int[data.length];

        for (int i = 0; i < data.length; i++) {
            inputNum[i] = parseInt(data[i]);

        }
        Set<Integer> removeDuplicates = new HashSet<Integer>();
        for (int j = 0; j < inputNum.length; j++) {
            removeDuplicates.add(inputNum[j]);
        }
        int[] finalSortArray = new int[removeDuplicates.size()];
        int k = 0;
        for (Integer move : removeDuplicates) {
            finalSortArray[k++] = move;
        }
        Arrays.sort(finalSortArray);
        if (finalSortArray.length < index) {
            return "The index cannot be greater than the non-repeated numbers";                    
        } else {
            int result=finalSortArray[finalSortArray.length-index];                    
            return String.valueOf(result);
        }
    }

    private int parseInt(String indexNumber) {
        return Integer.parseInt(indexNumber);
    } 
}