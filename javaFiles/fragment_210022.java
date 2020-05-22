class Demo {

    public static void f1() throws MyException {
        throw new MyException(); // I forgot to add parenthesis.
    }

    public static void f2() throws MyException {
        f1();
    }

    public static void f3() throws MyException {
        f2();
    }

    public static void main(String[] args) {
        try {
            f3();
        } catch (Exception e) {
            System.out.println("Exception in handled in main method");
        }
    }
}

class MyException extends Exception {

}