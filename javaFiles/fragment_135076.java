public class Static {

    public static int var = returnCount();

    public static int count = 0;
    public static int returnCount() {
        count = count + 1;
        return count;
   }
}