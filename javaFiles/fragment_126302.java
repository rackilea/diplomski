public class OverLoadedToString {

    public static void main(String[] args) {
        Son son = new Son();
        son.test();
        son.test(90);
    }
}

class Dad {

    void test() {
        System.out.println("Dad - test");
    } 
}

class Son extends Dad {

    void test(int testTime) {
        System.out.println("Son - test1" + testTime);
    }
}