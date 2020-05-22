public class Perms {

/**
 * @param args
 */
public static int x;
public static void main(String[] args) {
    // TODO Auto-generated method stub

    x = 6;
    rec(x, new int[1000], new String[1000], 0);
}

public static void rec(int n, int all[], String operator[], int size)
{
       if (n==0)
       {
          if (size==1)return;
          System.out.print(x + " =");
          for (int i=0;i<size;i++)
          {
             System.out.print(" " + all[i]);
             if (i!=size-1)
                 System.out.print(" " + operator[i]);
          }
          System.out.println();
          return;
       }
       int i=1;
       if (size>0)
          i = all[size-1]+1;
       for ( ;i<=n;i++)
       {
          operator[size] = "+";
          all[size] = i;
          rec(n-i, all, operator, size+1);
       }

       i=1;
       if (size>0)
          i = all[size-1]+1;
       for (;i<=n;i++)
       {
          float r = n/(float)i;
          if (r == (int)r)
          {
             operator[size] = "*";
             all[size] = i;
             rec(n/i, all, operator, size+1);
          }
       }
    }
}