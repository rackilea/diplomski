Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
for(i=1; i<=n; i++)
{
    if(i%3==2 && i%5==0)
    {
        System.out.println("Bus");
    }
    else if(i%3==1 && i%5==0)
    {
        System.out.println("bUs");
    }
    else if(i%3==0 && i%5==0)
    {
        System.out.println("buS");
    }
    else
    {
        System.out.println(i+" ");
    }
}