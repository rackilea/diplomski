import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Testing {

    public static void main(String[] args) {
        int minX = 0;
        int minY = 100000;
        int maxX = 20;
        int maxY = 2000000;

        Map<Integer, Integer> hashToCounts = new HashMap<Integer, Integer>();
        for (int x = minX; x < maxX; x++) {
            for (int y = minY; y < maxY; y++) {
                int hash = hash(x, y);
                Integer count = hashToCounts.get(hash);
                if (count == null)
                    count = 0;
                hashToCounts.put(hash, ++count);
            }
        }

        int totalCollisions = 0;
        for (Entry<Integer, Integer> hashCountEntry : hashToCounts.entrySet())
            if (hashCountEntry.getValue() > 1)
                totalCollisions += hashCountEntry.getValue() - 1;

        System.out.println("Total collisions: " + totalCollisions);
    }

    private static int hash(int x, int y) {
        return 7 + y * 31 + x * 23;
    }
}