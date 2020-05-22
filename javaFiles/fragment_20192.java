import java.util.ArrayList;
import java.util.List;


public class myArray {

    /**
     * @param args
     */
    public static void main(String[] args) {


        int[] values = new int[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };


        // Add the result to ArrayList.
        List<Integer> temp = new ArrayList<Integer>();
        List<Integer> temp1 = new ArrayList<Integer>();


        for(int i=0;i<values.length; i++) {
                if (values[i] % 2 == 0){
                    temp.add(values[i]);
                } else {
                    temp1.add(values[i]);
                }
        }

         System.out.println(temp);
         System.out.println(temp1);
    }
}