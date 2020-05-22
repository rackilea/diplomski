public class Test {

    static int i = 0;

    public static void main(String[] args) {

        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(getNext(), "One");
        map.put(getNext(), "Two");
        map.put(getNext(), "Three");
        map.forEach((key, value) -> System.out.println("Key = " + key + ", value = " + value));
    }

    static int getNext() {
        i = i+1;
        return i;
    }
}