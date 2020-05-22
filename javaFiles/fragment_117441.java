public class MyClassWithStaticCounter {
    private static int counter = 0;

    public static void increaseCounter(int i){
        counter += i;
    }

    public static int getCounter(){
        return counter;
    }
}