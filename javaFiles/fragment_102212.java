import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {
        int number = 2;
        List<String> nodes = new ArrayList<>(Arrays.asList("Hello",
            "World!", "How", "Are", "You"));
        ListIterator<String> nodesIterator = nodes.listIterator();
        while (nodesIterator.hasNext()) {
            nodesIterator.next();
            int fromIndex = nodesIterator.previousIndex();
            List<String> nodesToCheck = nodes.subList(fromIndex,fromIndex + number);
            if (nodesToCheck.contains("Hello")) {
                for (String n : nodesToCheck) { //ConcurrentModificationException 
                    // thrown here at beginning of second iteration
                    nodesIterator.remove();
                    nodesIterator.next();
                }
                List<String> nodesToReplace = new ArrayList<>(
                    Arrays.asList("replace"));
                for (String n : nodesToReplace) {
                    nodesIterator.add(n);
                }
            }
        }
    }
}