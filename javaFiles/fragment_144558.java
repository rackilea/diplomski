public class Test{
    public static void main(String... args){
        int f=5;
        System.out.println(fact(f));
    }
    public static int fact(int n){
        if(n==1) return n;
        return n*fact(n-1)*n;
    }
}