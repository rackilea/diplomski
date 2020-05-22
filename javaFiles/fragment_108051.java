public class Test {
    public static void main(String[] args){
        doSomething(new char[5], new char[6]);
        doSomething(new char[2][3]);
    }

    private static void doSomething(char[]... args){
        for(char[] s : args){
            System.out.println(s.length);
        }
    }
}