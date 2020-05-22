import java.util.HashMap;

public class MapDem {

    final HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    public HashMap<Integer, Integer> getMap() {
        return map;
    }

    public void putValue(int key, int value) {
        map.put(key, value);
    }

    public static void main(String args[]) {
        MapDem demo = new MapDem();

        demo.putValue(1, 10);
        demo.putValue(1, 10);

        System.out.println(demo.getMap().size());
    }
}