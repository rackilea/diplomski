public static class OrderedList<T> extends AbstractList<T> {

    // The list I proxy.
    private final List<T> it;
    // The order.
    private final int[] order;

    public OrderedList(List<T> wrap) {
        it = wrap;
        order = new int[it.size()];
        // Initially the same order.
        for (int i = 0; i < order.length; i++) {
            order[i] = i;
        }
    }

    @Override
    public T get(int index) {
        return it.get(order[index]);
    }

    @Override
    public int size() {
        return it.size();
    }

    // TODO - Only moves up! Breaks on a down move.
    public void move(int start, int length, int to) {
        int[] move = new int[length];
        // Copy it out.
        System.arraycopy(order, start, move, 0, length);
        // Shift it down.
        System.arraycopy(order, start + length, order, start, to - start);
        // Pull it back in.
        System.arraycopy(move, 0, order, to, length);

    }
}

public void test() {
    List<String> t = Arrays.asList("Zero", "One", "Two", "Three", "Four", "Five");
    OrderedList<String> ordered = new OrderedList(t);
    System.out.println(ordered);
    ordered.move(1, 2, 3);
    System.out.println(ordered);
}