public class Test {
    static Deque<Integer> bfs = new ArrayDeque<>();

    public static void main(String[] args) {
        bfs.add(1);
        bfs.add(2);
        bfs.add(3);

        Iterator<Integer> revbfs = bfs.descendingIterator();
        while(revbfs.hasNext()) {
            System.out.println(revbfs.next());
        }
        // output is 3, 2, 1
    }

}