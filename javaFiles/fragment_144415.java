public class Test {
    public static void main(String[] args) {
        int[] stuff = {1};
        System.out.println("before: " + stuff[0]);
        doStuff(stuff);
        System.out.println("after: " + stuff[0]);
    }
    public static void doStuff(int[] array){
        array[0]=10;
    }
}