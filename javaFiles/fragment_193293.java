import java.util.*;
class neon
{
  public static void main(String args[])
  {
    Scanner me = new Scanner(System.in);
    System.out.print("  What's about the lower limit ?   ");
    int l=me.nextInt();
    System.out.println();
    System.out.print("  What's about the upper limit ?   ");
    int h=me.nextInt();
    System.out.println();
    for(int i=l;i<=h;i++)
    {
        int sum=0;
        int ii=i*i;
        while(ii!=0){   
            int a=ii%10;
            ii=ii/10;
            sum+=a;
        }
        if(sum==i)
        {
            System.out.println(i+"\t");
            break;
        }
    }
  }
}