public static void runningSum(IntList l)
{ 
    IntList head = l;
    int rSum = l.sumList();

    while(l != null) 
    {
        int curRS = rSum;
        curRS -= l.getValue();
        l.setValue(rSum);
        rSum = curRS;
        l = l.getNext();
    }

    System.out.println(head.toString());
}