class TestException extends except2 {
    public static void main(String[] args) throws Exception {
        try {
            try {
                throw new TestException();
            } catch (final TestException e) {
                System.out.println("d");
            }
            throw new ArithmeticException();
        } catch (TestException a) {
        } catch (Exception e) {
            throw e;
        }
    }
}