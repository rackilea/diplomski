public class Wrong {
    int a = getB(); // Don't do this!
    int b = 10;
    public int getB() {
         return b;
    }
}