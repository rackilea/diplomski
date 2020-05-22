public class MyClass {
    public static void main(String[] args) {
        System.out.println(basepowerexp(2, 3));
    }

    public static int basepowerexp(int base, int exp){
        if (exp == 0) {
            return 1;
        } else {
            return base * basepowerexp(base, exp - 1);
        }
    }
}