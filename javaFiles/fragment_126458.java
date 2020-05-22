public class ThreadSafeExample {
    private Vector<String> names = new Vector<String>();

    public void addName(String name) {
       names.add(name);
    }
}