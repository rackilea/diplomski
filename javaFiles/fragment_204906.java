public static int recursion(int big,int small)
{
    int remainder=big%small;
    if(remainder==0)
    {
        System.out.println(small);
    }
    else
    {
        big=small;
        small=remainder;
        return recursion(big,small);
    }
    return small;
}