/* Function to delete node with the key */
public void deleteWithKey(int key) {
    if (key == head.getData()) {
        if (size == 1) {
            head = null;
            end = null;
            size = 0;
            return;
        }
        head = head.getLinkNext();
        head.setLinkPrev(end);
        end.setLinkNext(head);
        size--;
        return;
    }
    if (key == end.getData()) {
        end = end.getLinkPrev();
        end.setLinkNext(head);
        head.setLinkPrev(end);
        size--;
    }
    Node next = head;
    Node back = head;
    while (next != end) {
        next = next.getLinkNext();
        back = back.getLinkPrev();
        if ((key == next.getData()) && (key == back.getData()) && (next != back)) {
            Node p = next.getLinkPrev();
            Node n = next.getLinkNext();
            Node p1 = back.getLinkPrev();
            Node n1 = next.getLinkNext();
            p.setLinkNext(n);
            n.setLinkPrev(p);
            p1.setLinkPrev(n1);
            n1.setLinkPrev(p1);
            size -= 2;
            return;
        }

        if ((key == next.getData()) && (next != back)) {
            Node p = next.getLinkPrev();
            Node n = next.getLinkNext();
            p.setLinkNext(n);
            n.setLinkPrev(p);
            size--;
            return;
        }
        if ((key == next.getData()) && (next == back)) {
            Node p = next.getLinkPrev();
            Node n = next.getLinkNext();
            p.setLinkNext(n);
            n.setLinkPrev(p);
            size--;
            return;
        }
    }
    System.out.println("Don't exist a node with this key");
}