public class TestInt {
    public static void main(String[] args) throws Exception
    {
        Thread.currentThread().interrupt();

        synchronized(TestInt.class) {
            TestInt.class.wait();
        }    
    }    
}