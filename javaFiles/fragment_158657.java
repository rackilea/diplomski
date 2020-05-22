import java.util.ArrayList;

public class ArraysAndLists {
    public static void main(String[] args) {
        ArrayList<String>[] touchPoints = new ArrayList[2];

        // Adding values
        touchPoints[0] = new ArrayList<String>();
        touchPoints[0].add("one string in the first ArrayList");
        touchPoints[0].add("another string in the first ArrayList");

        touchPoints[1] = new ArrayList<String>();
        touchPoints[1].add("one string in the second ArrayList");
        touchPoints[1].add("another string in the second ArrayList");

        // touchPoints[2].add("This will give out of bounds, the array only holds two lists");

        // Reading values
        System.out.println(touchPoints[0].get(0)); // returns "one string in the first ArrayList"
        System.out.println(touchPoints[1].get(1)); // returns "another string in the second ArrayList"

    }
}