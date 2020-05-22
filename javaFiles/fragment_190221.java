import java.util.ArrayList;
import java.util.List;

public class GenericTest {

    public static void main(String[] args) {
        List<Boolean> booleanList;

        List<Integer> intList = new ArrayList<>();
        intList.add(42);

        List objects = intList;
        booleanList = objects;
        System.out.println(booleanList);
    }
}