import org.junit.Test;

public class RandomCastTest {

    public interface Set {
        boolean isEmpty();

        void add(int x);

        void difference(Set other, Set result);

        @Override
        String toString();

        @Override
        boolean equals(Object other);
    }

    public class LinkedListSet implements Set {
        private class Node  //much easier as a private class; don't have to extend
        {
            private int data;
            private Node next;

            public Node() {
            }

            public Node(int x) {
                data = x;
            }

            public int data() {
                return data;
            }

            public Node next() {
                return next;
            }

            public void next(Node node) {
                next = node;
            }
        }

        private Node first;
        private int Size;
        private int whichList; //used to identify the particular LL object

        @Override
        public boolean isEmpty() {
            return first == null;
        }

        @Override
        public void add(int x) {
            Node node = new Node(x);

            if (first == null) {
                first = node;
            } else {
                Node currentNode;
                Node nextNode = first;
                do {
                    currentNode = nextNode;
                    nextNode = currentNode.next();
                } while (nextNode != null);

                currentNode.next(node);
            }
            Size++;
        }

        @Override
        public void difference(Set other, Set result) {
            if (other.isEmpty()) {
                System.out.println("The set is empty before cast");
            }
            LinkedListSet othr = (LinkedListSet) other;
            LinkedListSet res = (LinkedListSet) result;
            if (this.isEmpty() || othr.isEmpty()) {
                if (othr.isEmpty())
                    System.out.println("The set is empty after cast");
                if (this.isEmpty())
                    System.out.println("This is also empty");
                return;
            }
            result = res;
        }
    }

    @Test
    public void test() {
        Set[] sets = new Set[7];
        for (int i = 0; i < sets.length; i++) {
            sets[i] = new LinkedListSet();
        }

        for (int i = 0; i < 5; i++) {
            sets[1].add(i);
        }

        for (int i = 5; i < 10; i++) {
            sets[0].add(i);
        }

        sets[0].difference(sets[1], sets[4]);
        // ... find difference
    }
}