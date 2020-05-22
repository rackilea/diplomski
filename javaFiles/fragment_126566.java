private static void bubbleSortByOccurrences(int[] arr) {
    Bubble head = null;

    for (int value : arr) {
        if (head == null) {
            head = new Bubble(value);
        } else {
            Bubble currentHead = null;
            Bubble current = head;

            for (; current != null && !(current.getValue() == value); current = current.getTail()) {
                currentHead = current;
            }

            if (current == null) {
                current = new Bubble(value);
                current.setTail(head);
                head = current;
            } else {
                current.incrementOccurrences();

                while (current.getTail() != null && current.getOccurrences() > current.getTail().getOccurrences()) {
                    Bubble currentTail = current.getTail();
                    current.setTail(currentTail.getTail());
                    currentTail.setTail(current);

                    if (currentHead != null) {
                        currentHead.setTail(currentTail);
                        currentHead = currentTail;
                    } else {
                        head = currentTail;
                    }
                }
            }
        }
    }

    fillArrayBackwards(arr, head);
}

private static void fillArrayBackwards(int[] buf, Bubble head) {
    int i = buf.length - 1;
    for (Bubble current = head; current != null; current = current.getTail()) {
        for (int j = 0; j < current.getOccurrences(); j++) {
            buf[i--] = current.getValue();
        }
    }
}