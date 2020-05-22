class GenericStack<Item>{
    class Stack {

        private Node first=null;

        private class Node {
            Item item;
            Node next;
        }

        public boolean IsEmpty()
        {
            return first==null;
        }

        public void push (Item item)
        {
            Node oldfirst = first;
            first = new Node();
            first.item = item;
            first.next = oldfirst;
        }

        public Item pop ()
        {
            Item item=first.item;
            first=first.next;
            return item;
        }
    }
}

public class Main {

/**
 * @param args
 */
public static void main(String[] args) {
    // TODO Auto-generated method stub
    GenericStack<Integer> ob = new GenericStack<Integer>();
    GenericStack<Integer>.Stack st=ob.new Stack();
    st.push(5);
    st.push(10);
    st.push(15);
    while (!st.IsEmpty())
    {
        int x=st.pop();
//        StdOut.print(x);
        System.out.println(x);
    }

  }
}