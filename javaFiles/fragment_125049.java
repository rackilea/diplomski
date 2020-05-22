import java.util.List;
import java.util.ArrayList;

public class Example {
    public static final void main(String[] args) throws Exception {
        String[] array = new String[10];
        List<String> list = new ArrayList<String>(array.length);
        for (int n = 0; n < array.length; ++n) {
            array[n] = "foo" + System.currentTimeMillis();
            list.add(array[n]);
        }

        useArray(array);
        useList(list);

        System.out.println("Done");
    }

    public static void useArray(String[] array) {
        System.out.println("Using array:");
        for (String s : array) {
            System.out.println(s);
        }
    }

    public static void useList(List<String> list) {
        System.out.println("Using list:");
        for (String s : list) {
            System.out.println(s);
        }
    }
}