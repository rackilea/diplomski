public class HeadedList implements List {

    private final List tail;

    public HeadedList(T head, List tail) {
       this.head = head;
       this.tail = tail;
    }

    public T get(int index) {
        return index == 0 ? head : tail.get(index - 1);
    }

    ...
}