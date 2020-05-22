interface FIface<T> {
    int testMethod(T a, T b);
}

class Test2 {

    private String str;

    Test2(String str) {
        this.str = str;
    }

    int ok(Test2 test2) {
        System.out.println("Currnet String : "+ this.str);//Refer to t1
        System.out.println("Test String : "+test2.str);//Refer to t2
        return 0;
    }

}

public class Test {

    public static <T> int checkCall(T t1, T t2, FIface<T> fiFace) {
        //Here Test2 :: ok is equivalent to t1.ok(t2)
        return fiFace.testMethod(t1, t2);
    }

    public static void main(String[] args) {
        checkCall(new Test2("a"), new Test2("b"), Test2 :: ok);
    }

}