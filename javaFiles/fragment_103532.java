public class Main {
    void recursiveMethod(int a, int b) {
        for(int i=0;i<a;i++)
          System.out.print(a);
        System.out.println();
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