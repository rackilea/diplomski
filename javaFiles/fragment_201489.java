import java.util.*;
import java.util.stream.*;

public class Test {
    public static void main(String[] args) throws Exception {
        Map<String, Double> unordered = new HashMap<>();
        unordered.put("a", 10.5);
        unordered.put("b", 5.3);
        unordered.put("c", 12.7);
        unordered.put("d", 6.0);

        Map<String, Double> ordered = orderByDescValue(unordered);
        for (Map.Entry<String, Double> entry : ordered.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static Map<String, Double> orderByDescValue(Map<String, Double> unorderedMap) {
        return unorderedMap.entrySet().stream()
            .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (x, y) -> { throw new IllegalStateException("Unexpected merge request"); },
                LinkedHashMap::new));
    }
}