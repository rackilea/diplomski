class TestException extends except2 {
    public static void main(String[] args) throws Exception {
        try {
            throw new ArithmeticException();
        } catch (TestException a) {
        } catch (Exception e) {
            throw e;
        }
    }
}