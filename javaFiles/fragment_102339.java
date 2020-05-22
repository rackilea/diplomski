class abc{
    int a;
    static int b;
    static abc h;//line 4

    static {
        h = new abc();//line 4 (split)
        System.out.println("stat");
    }

    public abc() {
        a = 0;
        System.out.println("ini");
        System.out.println("cons");
    }
}

public class ques{
    public static void main(String[] args) {
        System.out.println(new abc().a);
    }
}