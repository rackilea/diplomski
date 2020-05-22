import java.util.*;

class Someclass
{

public static class IntegerWr 
    implements Comparable<IntegerWr>
{
    Integer val;

    IntegerWr(Integer val)
    {
        this.val = val; 
    }

    public void change(Integer nval)
    { 
        this.val = nval;
    }

    @Override
    public int compareTo(IntegerWr iw)
    {
        return val.compareTo(iw.val);
    }
    @Override public String toString()
    {
        return ""+val;
    }
}
    public static void main (String[] args) 
    {
        PriorityQueue<IntegerWr> pq = new PriorityQueue<>();
        pq.add(new IntegerWr(3));
        System.out.println(pq.peek());
        IntegerWr iw1 = new IntegerWr(1);        
        pq.add(iw1);
        System.out.println(pq.peek());
        pq.add(new IntegerWr(4));
        System.out.println(pq.peek());
        pq.add(new IntegerWr(2));
        System.out.println(pq.peek()); //must output 1, and does so
        iw1.change(5);                 //change value of element that is actually on peek
        System.out.println(pq.peek()); //outputs 5 which is unexpected
        pq.add(new IntegerWr(0));
        System.out.println(pq.peek()); 

        System.out.println("Elements ordered");
        Object o = null;
        while ((o = pq.poll()) != null) //poll() method removes and return
                                        //the head of the queue.
                                        //Exactly which element is removed 
                                        //from the queue is a function 
                                        //of the queue's ordering policy
        {
            System.out.println(o);
        }
    }
}