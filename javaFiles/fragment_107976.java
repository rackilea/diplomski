private List<Integer> list;
private int key = 27;
private static volatile boolean found;

public Test(List<Integer> list, boolean value) {
    this.list = list;
    this.found = value;
}

@Override
public void run() {
    for (int i = 0; i < list.size(); i++) {
        // Has the other thread found it?
        if (found) {
            Thread.currentThread().interrupt();
        }
        if (list.get(i) == key) {
            System.out.println("Found by: " + Thread.currentThread().getName());
            // I found it!
            found = true;
            Thread.currentThread().interrupt();
        }
        System.out.println(Thread.currentThread().getName() + ": " + list.get(i));
    }
}