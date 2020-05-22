public class ThisTest
{
    public static <T extends Comparable<T>> int compare(T x, T y) {
        if (x == null) 
            return -(y.compareTo(x));
        return x.compareTo(y);
    }

    public static void main()
    {
        // Type inferred
        int c = compare(Integer.valueOf(0), Integer.valueOf(1));
        // Explicit generic type parameter
        c = ThisTest.<Integer>compare(Integer.valueOf(0), Integer.valueOf(1));
    }
}