public class TestCls {

    public static int test = getInt();
    public static int moreJunk = initializeMoreJunk();

    static{
        System.out.println("Static initializer: test=" + test + ", moreJunk=" + moreJunk);
    }

    public static int getInt(){

        System.out.println("giveInt func: " + test);
        System.out.println("moreJunk=" + moreJunk);
        return 10;
    }

    public static int initializeMoreJunk() {
        return -1;
    }

    public static void main(String... args){
        System.out.println("Main: " + test);
    } 
}