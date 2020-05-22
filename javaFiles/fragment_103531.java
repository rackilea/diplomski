public class Main {
    void recursiveMethod(int a, int b) {
        System.out.println(a);
        a++;
        if(a==b)
            return;
        else
            recursiveMethod(a, b);
    }
    public static void main(String[] args) {
        new Main().recursiveMethod(1, 10);
    }
}