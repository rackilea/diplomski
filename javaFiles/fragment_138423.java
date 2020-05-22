public class Main {

    public static void main(String[] args) {
        // do your stuff, ask the user or what you want here, for example:
        SlumpTal1 tail1 = new SlumpTal1();  // execute 2 threads
        tail1.start();
        SlumpTal2 tail2 = new SlumpTal2();  // execute 4 threads
        tail2.start();
    }
}