import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author blj0011
 */
public class JavaApplication114
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // TODO code application logic here
        List<String> stringList = new ArrayList<>();
        stringList.add("a");
        stringList.add("abc");
        stringList.add("b");
        stringList.add("fe");
        stringList.add("e");
        stringList.add("ABC");
        stringList.add("Abc");
        stringList.add("ABc");

        System.out.print("Before Sort:");
        System.out.println(stringList);

        Collections.sort(stringList, new Comparator<String>()
        {
            @Override
            public int compare(String o1, String o2)
            {
                if (o1.length() > o2.length()) {
                    return 1;
                }
                else if (o1.length() < o2.length()) {
                    return -1;
                }
                else if (o1.length() == o2.length()) {
                    if (o1.length() == 1) {
                        return o1.compareTo(o2);
                    }
                    else {
                        return o2.compareTo(o1);
                    }

                }
                else {
                    return 0;
                }
            }
        });
        System.out.print("After Sort :");
        System.out.println(stringList);
    }
}