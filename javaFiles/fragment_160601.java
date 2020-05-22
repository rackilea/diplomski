public class Main {

    public static void main(String[] args) {
        System.out.println(math(1.5f));
        System.out.println(math(1.500001f));
        System.out.println(math(1.49999f));
    }

    public static int math(float f) {
        int c = (int) ((f) + 0.5f);
        float n = f + 0.5f;
        return (n - c) % 2 == 0 ? (int) f : c;
    }

}