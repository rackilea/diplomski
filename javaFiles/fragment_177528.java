public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter the limit");
    double n=sc.nextDouble();
    double sum=0;
    double j=1;
    for(double i=1;i<=n;i++)
    {
        if(i%2==0)
            sum=sum-(++j/++j);
        else
            sum=sum+(++j/++j);
    }
    System.out.println(sum);
}