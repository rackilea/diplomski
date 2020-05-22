/**
 * @pre. n >= 1
 */
public void push(T element) {
    if (count >= n) {
        assert top != null;
        prev = null;
        curr = top;
        while (curr.getNext() != null) {
            prev = curr;
            curr = curr.getNext();
        }
        if (prev != null) {
            prev.setNext(null);
        } else {
            top = null;
        }
        count--;
    }
    LinearNode<T> temp = new LinearNode<>(element);
    temp.setNext(top);
    top = temp;
    count++;
}