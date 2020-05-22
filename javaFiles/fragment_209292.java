public class Main {

    public static void foo(String a){
        a="2";
    }

    public static void main(String[] args) {
        String x="1";
        foo(x);
        System.out.println("x="+x);

    }

}