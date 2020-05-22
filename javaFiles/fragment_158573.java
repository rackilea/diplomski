public class practice{ 
    public int[] doubler(int[] a)
    {
        int[] b = new int[a.length];
        for(int i = 0; i< a.length; i++)
        {
            b[i] = 2*a[i];
        }
        return b;
    }
    public static void main(String[] args) 
    {
    int[]c = {1,2,3,4,5};
        Practice w = new Practice();
        int[] s=w.doubler(c);
        for(int count = 0; count<s.length; count++)
        {
            System.out.print(s[count] + " ");
        }
    } 
}