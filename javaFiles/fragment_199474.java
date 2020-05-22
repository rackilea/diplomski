public E removeFirst() {
        E value=first.val;

        first=first.next;
        size--;
        }

        return value;
}