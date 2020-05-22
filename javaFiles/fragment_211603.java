public static void main()
{
    int num;
    System.out.print("\fInput:");
    num=kb.nextInt();
    int count=2;
    factors(num, count);

}



public static void factors(int num, int count)
{  
    if (num == 1)
        return;

    if((num%count)==0)
    {
        System.out.print(count+ " * ");
        factors(num/count, count);
    }
    else 
        factors(num,count+1);
    }
}