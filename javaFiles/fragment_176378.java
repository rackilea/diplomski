for(int i=0;i<myStrArray.length;i++);





import java.io.Console;
import java.util.Arrays;

public class HowToSortAnArray {
static Console c;
public static void main(String[] args) {

    String[] myStrArray = new String[5];

    for(int i=0;i<myStrArray.length;i++) {
         System.out.println("Input word: ");
        myStrArray[i]= "abdfg";
    }

    Arrays.sort(myStrArray, String.CASE_INSENSITIVE_ORDER);

    for (int a = 0; a < myStrArray.length; a++) {
         System.out.println(myStrArray[a]);
    }
}