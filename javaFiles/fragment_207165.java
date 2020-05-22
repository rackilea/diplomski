import java.util.Scanner;
import static java.lang.Math.pow;

public class subSet{

void subset(int num,int n, int x[])
{
    int i;
    for(i=1;i<=n;i++)
        x[i]=0;
    for(i=n;num!=0;i--)
    {
        x[i]=num%2;
        num=num/2;
    }
}
public static void main(String[] args) {
    int n,d,sum,present=0;
    int j;
    System.out.println("enter the number of items");
    Scanner sc=new Scanner(System.in);
    n=sc.nextInt();
    int a[]=new int[n+1];
    int x[]=new int[n+1];
    System.out.println("enter the weights of items");
    for(int i=1;i<=n;i++)
        a[i]=sc.nextInt();
    System.out.println("enter the values of items");
    int v[]=new int[n+1];
    for(int i=1;i<=n;i++)
        v[i]=sc.nextInt();
    System.out.println("enter the max weight");
    d=sc.nextInt();

    int sol=0;int max=0;
    if(d>0)
    {
        for(int i=1;i<=Math.pow(2,n)-1;i++)
        {
            subSet s=new subSet();
            s.subset(i,n,x);
            sum=0;int count=0;
            for(j=1;j<=n;j++)
                if(x[j]==1)
                {
                    sum=sum+a[j];
                    count++;
                }
            sol=0;
            if(d==sum && count%2==0)
            {
                present=1;
                for(j=1;j<=n;j++)
                {
                    if(x[j]==1)
                        sol=v[j]+sol;
                    if(sol>max)
                        max=sol;
                }
            }

        }

    }
    if(present==0)
        System.out.println("Solution does not exists");
    else
        System.out.print("solution = "+max);

}
}