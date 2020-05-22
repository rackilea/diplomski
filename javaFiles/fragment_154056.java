import java.io.*;
    class wert
    {
    public static void main(String[]ert)throws IOException
    {
    InputStreamReader ni=new InputStreamReader(System.in);
    BufferedReader in=new BufferedReader(ni);
    int k=0,i;
    int y[]=new int[3];
    int u[]=new int[3];
    int c[]=new int[6];
    for(i=0;i<3;i++)
    {
    y[i]=Integer.parseInt(in.readLine());
    }
    for(i=0;i<3;i++)
    {
    u[i]=Integer.parseInt(in.readLine());
    }
    for(i=0;i<3;i++)
    {
    if(k%2==0)
    {
    c[k++]=y[i];
    }
    k++;
    }
    k=1;//resetting the k
    for(i=0;i<3;i++)
    {
    if(k%2!=0)
    {
    c[k++]=u[i];
    }
    k++;
    }
    for(i=0;i<6;i++)
    {
    System.out.println(c[i]);
    }}}