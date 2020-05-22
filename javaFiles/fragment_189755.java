public class StaticThrow {
    static int foo = 0;
    {{ if (Math.sin(3) < 0.5) { throw new ArithmeticException("Heya"); } else { foo = 3; } }}
    public static void main(String[] args) {
        StaticThrow t = new StaticThrow();
        System.out.println(StaticThrow.foo);
    }
}