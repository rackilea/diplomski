public int[] read()
{
    int num [] = new int[10];
    Scanner s=new Scanner(System.in);

    for(i=0;i<num.length;i++)
    {
        System.out.println("Enter the number "+i);
        num[i] = s.nextInt();   
    }

    return num;
}