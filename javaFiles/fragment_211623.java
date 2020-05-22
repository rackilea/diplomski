public class FloatEqualsZero {
    public static void main(String [] args) {
        float x = 1;
        while(x != 0 && -x != 0) {
            x *= 0.1;
            System.out.println(x);
        }
    }
}