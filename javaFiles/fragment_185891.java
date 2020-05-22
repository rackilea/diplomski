public static <T> Collection <T> intersect (Collection <? extends T> a, Collection <? extends T> b)
{
    Collection <T> result = new ArrayList <T> ();

    for (T t: a)
    {
        if (b.remove (t)) result.add (t);
    }

    return result;
}

public static void main (String [] args)
{
    List <Integer> list1 = new ArrayList <Integer> (Arrays.<Integer>asList (2, 2, 2, 2, 5, 5));
    List <Integer> list2 = new ArrayList <Integer> (Arrays.<Integer>asList (2, 2, 103));
    List <Integer> list3 = new ArrayList <Integer> (Arrays.<Integer>asList (2, 431));

    System.out.println (intersect (list1, intersect (list2, list3)));
}