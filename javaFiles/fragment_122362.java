/**
 * 
 */
package data_structures;

import com.sun.corba.se.impl.orbutil.graph.Node;

/**
 * The ListNode<value_type> is a helper class for your 
 * LinkedList<value_type> class.  As its not intended for use
 * outside the LinkeList class, we are keeping it simple -- the
 * two properties will be access directly, instead of going through
 * inspectors and mutators.
 * 
 * DO NOT MODIFY THIST CLASS.
 * 
 * @param <value_type>  The type of object to be stored in the list.
 */
class ListNode<value_type> {
    public value_type value;
    public ListNode<value_type> next;

    public ListNode(value_type v) {
        value = v;
        next = null;
    }

    public ListNode(value_type v, ListNode<value_type> n) {
        value = v;
        next = n;
    }

}


/*
 * We will implement this as a single linked list.
 */
public class LinkedList<value_type> extends Sequence<value_type> {

    /**
     * head will be the first node of the list -- or null if the list is empty
     */
    private ListNode<value_type> head, tail;                      

    /**
     * List constructor: must call the superclass constructor.
     */
    public LinkedList() {
        super();
        head = null; 
        tail = null;
    }

    /* (non-Javadoc)
     * @see data_structures.Sequence#get(int)
     */
    @Override
    public value_type get(int i) {
        if (i < 0 || i >= size())
            throw new IndexOutOfBoundsException();


        ListNode<value_type> tmp = head;
        if (i==0) {
            return head.value;
        } else {
            for (int k=0; k < i; k++) {
                tmp = tmp.next;
            }
        }


        return tmp.value;
    }

    /* (non-Javadoc)
     * @see data_structures.Sequence#set(int, java.lang.String)
     */
    @Override
    public value_type set(int i, value_type value) {
        System.out.println(n);
        if (i < 0 || i >= size())
            throw new IndexOutOfBoundsException();

        if (i==0) {
            value_type s = head.value;
            head.value = value;
            return s;
        } else {
            ListNode<value_type> tmp = head;
            for (int k=0; k < i; k++) {
                tmp = tmp.next;
            }
            value_type s = tmp.value;
            tmp.value = value;
            return s;
        }
    }

    /* (non-Javadoc)
     * @see data_structures.Sequence#add(int, java.lang.String)
     */
    @Override
    public void add(int i, value_type value) {
        if (i < 0 || i > size())
            throw new IndexOutOfBoundsException();

        if (n==0) {
            head = new ListNode<value_type>(value, head);
            tail = head;
        } else if (i==0) {
            ListNode<value_type> u = new ListNode<value_type>(value, head);
            head = u;
        } else if (i==n) {
            ListNode<value_type> u = new ListNode<value_type>(value);
            tail.next = u;
            tail = u;           
        } else {
            ListNode<value_type> tmp;
            tmp = head;
            for(int k=0; k < i-1; k++) {
                tmp = tmp.next;
            }
            ListNode<value_type> u = new ListNode<value_type>(value, tmp.next);
            tmp.next = u;
        }

        n++;

    }

    /* (non-Javadoc)
     * @see data_structures.Sequence#remove(int)
     */
    @Override
    public value_type remove(int i) {
        if (i < 0 || i >= size())
            throw new IndexOutOfBoundsException();

        ListNode<value_type> tmp = head;
        if (i==0) {
            if (n==1) {
                head.next = null;
                n--;
                return head.value;
            } else {
                value_type save = head.value;
                head = head.next;
                n--;
                return save;
            }
        }
        for (int k=0; k < i-1; k++) {
            tmp = tmp.next;
        }

        ListNode<value_type> a = tmp;
        value_type save = tmp.next.value;
        ListNode<value_type> b = tmp.next.next;
        a.next = b;

        n--;

        return save;
    }

    /* (non-Javadoc)
     * @see data_structures.Sequence#clear()
     */
    @Override
    public void clear() {
        head = null;
        n = 0;
        tail=null;
    }



}