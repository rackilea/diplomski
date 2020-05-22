import java.util.ArrayList;
import java.util.List;

public class Sequence {

    private static int arr1[] = { 3, 88, 99, 5, 4, 6, 22, 32, 7, 45 };

    private static int findNextInSequence(int start) {
        int next = -1;

        for(int i = 0; i < arr1.length; i++){
            if((start - arr1[i]) == -1){
                next = arr1[i];
            }
        }

        return next;
    }

    public static void main(String[] args) {


        for (int i = 0; i < arr1.length; i++) {

            List<Integer> sequence = new ArrayList<Integer>();
            int nextSequence = arr1[i];
            do{
                sequence.add(nextSequence);
                nextSequence = findNextInSequence(nextSequence);
            } while(nextSequence != -1);

            System.out.println(sequence);
        }
    }
}