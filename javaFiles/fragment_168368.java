public static void main(String[] args)
{
    Scanner s=new Scanner(System.in);
    System.out.println("enter the size of the array");
    int size=s.nextInt();
    int[] a=new int[size];
    System.out.println("enter the array values");
    for(int i=0;i<size;i++)        
        a[i]=s.nextInt();
    System.out.println("The differences sum : "+SumUntilBigger(a));
}