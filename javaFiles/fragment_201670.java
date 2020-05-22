import java.util.ArrayList;
import java.util.Collections;


public class Driver {

    /**
     * @param args
     */
    public static String[] names = new String[] {"Monkey1", "Dog2", "Horse3", "Cow4", "Spider5"};
    public static int[] data = new int[] {1,2,3,4,5};
    public static void main(String[] args) {
        ArrayList<StringIntTuple> list = new ArrayList<StringIntTuple>();
        for(int i =0; i<names.length; i++){
            list.add(new StringIntTuple(data[i],names[i]));
        }
        Collections.sort(list, new StringIntTupleIntComparator());
        System.out.println(list.toString());
        Collections.sort(list, new StringIntTupleStringComparator());
        System.out.println(list.toString());
    }


}