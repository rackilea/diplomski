import java.util.ArrayList;
import java.util.List;

//use a generic type argument T here that extends comparable so you can only store objects of a specific type that are comparable to each other
public class MinPriorityQueue<T extends Comparable<T>> {

    private List<T> queue; // Contents of the queue

    private int cap;
    //private int size;

    /**
     * Constructs a new MinPriorityQueue with capacity cap and size 0.
     * 
     * @param cap
     *        Capacity of the new queue.
     */
    public MinPriorityQueue(int cap) {
        this.queue = new ArrayList<T>(cap);
        //this.size = 0;
        this.cap = cap;
    }

    public int size() {
        //return this.size;
        return queue.size();
    }

    public int capacity() {
        return this.cap;
    }

    public boolean isEmpty() {
        //return this.size == 0;
        return queue.isEmpty();
    }

    public boolean isFull() {
        //return this.size == cap;
        return queue.size() == cap;
    }

    public void insert(T e) {
        if (queue.size() == cap) {
            throw new IllegalStateException();
        }
        //queue[size] = e;
        //size++;
        queue.add(e);
    }

    /**
     * Removes and returns the lowest-priority item from the queue.
     * 
     * Complexity: O(n)
     * 
     * @return Lowest priority item that was in the queue.
     * @throws IllegalStateException
     *         if the queue is empty.
     */
    public Comparable<T> remove() {
        if (queue.size() == 0) {
            throw new IllegalStateException();
        }

        /*for (int i = 0; i < this.size; i++) {
            if (this.queue[i] == queue[size]) {
                return i;
            }
        }
        return queue[--size];*/

        //initialize the lowest priority item with the first one in the list
        int lowestPriorityIndex = 0;

        //search every other item in the list to see whether it has a lower priority than the current lowest priority 
        for (int i = 1; i < queue.size(); i++) {
            if (queue.get(i).compareTo(queue.get(lowestPriorityIndex)) < 0) {
                lowestPriorityIndex = i;
            }
        }

        //return and remove the lowest priority item
        return queue.remove(lowestPriorityIndex);
    }

    /**
     * Returns, but does not remove, the lowest-priority item in the queue.
     * 
     * Complexity: O(n)
     * 
     * @return Lowest priority item.
     * @throws IllegalStateException
     *         if the queue is empty.
     */
    public Comparable<T> top() {
        if (queue.size() == 0) {
            throw new IllegalStateException();
        }
        /*  int i;
          for (i=0; i < size; i++) {
        if (queue[i].compareTo (size-1) < 0) {
           break;
        }
        }
          return queue[size - 1];*/


        //initialize the lowest priority item with the first one in the list
        int lowestPriorityIndex = 0;

        //search every other item in the list to see whether it has a lower priority than the current lowest priority 
        for (int i = 1; i < queue.size(); i++) {
            if (queue.get(i).compareTo(queue.get(lowestPriorityIndex)) < 0) {
                lowestPriorityIndex = i;
            }
        }

        //return (but not remove) the lowest priority item
        return queue.get(lowestPriorityIndex);
    }
}