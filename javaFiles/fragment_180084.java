import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

    public class TwoButtons {


        public static void main(String[] args){
            Collection<Integer> c1 = new ArrayList<>(Arrays.asList(1,2,3));
            Collection<Integer> c2 = new ArrayList<>(Arrays.asList(3,2,1));

            System.out.println("equals " + c1.equals(c2));
            System.out.println("containsAll " + c1.containsAll(c2));
        }
    }