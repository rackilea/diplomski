public class MyObject {
    private String name;
    private int id;
    private long time;

}

public static Comparator<MyObject> COMPARE = new Comparator<MyObject>() {
    @Override
    public int compare(MyObject o1, MyObject o2) {
        return (int) (o1.time - o2.time);
    }
};

public PriorityQueue<MyObject> queue = new PriorityQueue<>(COMPARE);