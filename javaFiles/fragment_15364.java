class Node
{
    int num = 0;
}

class TestPassByReference
{
    void increaseByOne(Node N)
    {
        N.num++ ;
        System.out.println("num value is:" + N.num);
    }

    void increaseByOneThenChange(Node N)
    {
        // increase by one as before
        N.num++;
        // change the reference to a new object
        N = new Node();
        System.out.println("num value is:" + N.num);
    }

    public static void main(String args[])
    {
        Node N = new Node() ;
        TestPassByReference T  = new TestPassByReference() ;
        T.increaseByOne(N) ;
        System.out.println("num = "+N.num) ;
        T.increaseByOne(N) ;
        System.out.println("num = "+N.num) ;
        T.increaseByOne(N) ;
        System.out.println("num = "+N.num) ;

       // now try this method to see the difference
       T.increaseByOneThenChange(N);
       // N here is the original object, whose `num` value was incremented
       // but the reference remains unchanged by the above method
       System.out.println("num = "+N.num) ;
    }
}