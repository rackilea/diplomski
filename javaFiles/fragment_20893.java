class TestException extends except2 {
    public static void main(String[] args) throws Exception {
        try {
            try {
                throw new ArithmeticException();
            } catch (final TestException e) { // nothing above throws a TestException
                throw e;
            }
        } catch (TestException a) {
        }
        catch (Exception e) {

            throw e;
        }
    }
}