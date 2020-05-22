private <A extends Comparable<A>> void bigger(A a, A b)
{
    if(a.compareTo(b) > 0)
        System.out.println("a bigger");
    else
        System.out.println("b bigger");
}