public static void main(String[] args)
{
    int[] original = new int[5];//already allocating memory, initializing to default value, etc.
    setFirstTo20(original);
    System.out.println(original[0]);//still 20!
}

public static void setFirstTo20(int[] given)
{
    for (int i : given)
        System.out.println(i);//for debugging, before change
    given[0] = 20;
    for (int i : given)
        System.out.println(i);//after change
    //heres whats happening to you
    given = new int[5];
    given[0] = 40;
    for (int i : given)
        System.out.println(i);//show new changes to NEW array
}