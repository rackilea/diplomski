public static void main (String[] args) throws java.lang.Exception
{
    int[] a = {4, 2, 3, 2, 0 };
    String b = "Radon";
    String[] result = stringHeads(a,b);
    for(String x : result) System.out.println(x);
    //Or you can write a separate display method instead.
}
public static String[] stringHeads(int[] p, String s) 
{

    String[] rad = new String[p.length];
    //Use this variable for array allocation/iteration.
    int i=0;
    //Simply iterate using this for-each loop.
    // This takes care of array allocation/ substring creation.
    for (int x : p)
        rad[i++] = s.substring(0,x);
    return rad; 
}