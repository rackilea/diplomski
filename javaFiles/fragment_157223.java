public static void main(String[] args)
{
    PriorityQueue< Node > theQ = new PriorityQueue< Node >();
    Node n = new Node();
    n.bound = 6;
    theQ.add(n);
    n = new Node();
    n.bound = 9;
    theQ.add(n);
    n = new Node();
    n.bound = 4;
    theQ.add(n);
    while ((n = theQ.poll()) != null)
        System.out.println("Bound = " + n.bound);
}