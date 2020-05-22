import java.util.*;
class subset 
{
 public static void main(String[] args)
 {
    int n,x,z;
    Scanner sc=new Scanner(System.in);
    n=sc.nextInt();
    x=sc.nextInt();
    int m[]=new int[n];
    long b=System.currentTimeMillis();
    for(int i=0;i<n;i++)
    {
        m[i]=sc.nextInt();

    }
    Arrays.sort(m);
    for(int i=0;i<m.length;i++)
    {
        System.out.print(" "+m[i]+" " );

    }
    z=func(0,m,x);
    System.out.println(z);
    System.out.println(System.currentTimeMillis()-b);
 }
 static int func(int i,int m[],int w)
 {
     if(i==m.length||m[i]>w)
     {
         return 0;

     }
     if(m[i]==w)
         return (1+func(i+1,m,w));
     else
     {
         return((func(i+1,m,w-m[i])+func(i+1,m,w)));     

     }
 }