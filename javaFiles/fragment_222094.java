// perhaps this what you meant to do... Maybe? Kinda?
public class PriorityQueue<E> extends Comparable<E>
{
    private ArrayList<E> queue = new ArrayList<E>();

    public PriorityQueue() { }

    public int size()         { return queue.size(); }

    public boolean isEmpty()  { return queue.isEmpty(); }

    public void insert(E element) {
        queue.add(queue.size(), element);
        siftUp(queue.size() - 1);
    }


    public void siftUp(int size) {
        E elem = queue.get(size);
        for (; size>0 && elem.compareTo(queue.get(size/2))==1; size=size/2)
            queue.add(size, queue.get(size/2));
        queue.add(size, elem);
    }
}