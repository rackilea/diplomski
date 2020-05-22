public class MyException {

    static int foo(int num) throws Exception {
        try {
            return bar(num);
        } catch (Exception e) {
            throw handleException(e); // this will throw the exception from the handleException
        //    throw new Exception("Exception in foo", e);
        }
    }

    static int bar(int num) throws IllegalArgumentException {
        if (num < 0) {
            throw new IllegalArgumentException("Num less than 0");
        }
        return num;
    }

    // This method now returns an exception, instead of throwing an exception
    static Exception handleException(Exception e) {
        System.err.println("Handling Exception: " + e);
        return new Exception(e);
    }

    public static void main(String[] args) throws Exception {
        int value = foo(-1);
    }
}