import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BoxingTest {

    public static void main(String[] args) throws Exception {

        List<Integer> intList = Arrays.asList(new Integer[]{14, 24, 69});
        List<Long> sourceLongList = Arrays.asList(new Long[]{14L, 17L});

        List<Long> resultsList;
        /* Test as in question code */
        resultsList = new ArrayList<Long>();
        for(int i : intList){
            if(!sourceLongList.contains(i)){
                resultsList.add(new Long(i));
            }
        }
        printList(resultsList);

        /* Can't box then widen, so cast */
        resultsList = new ArrayList<Long>();
        for(int i : intList){
            if(!sourceLongList.contains((long)i)){
                resultsList.add(new Long(i));
            }
        }
        printList(resultsList);

    }

    private static <T> void printList(List<T> values){
        StringBuilder contents = new StringBuilder();
        for(T value : values){
            contents.append(value);
            contents.append(" ");
        }
        System.out.println("List contains: " + contents);
    }

}