public class Echo {
    String x;
    public static void main(String[] args){ 
        testVoidMethod();
    }

    private static void testVoidMethod() {
        Echo e = new Echo();
        //x == null
        e.voidMethod("xyz");
        System.out.println("xyz".equals(e.x)); //true expected
    }

    private void voidMethod(String s) {
        x = s;  
    }
}