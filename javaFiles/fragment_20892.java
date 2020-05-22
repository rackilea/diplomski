class TestException extends except2 throws Exception {
    public static void main(String[] args) {
        try {
            throw new except2(); // this
        } catch (TestException a) {
        } catch (Exception e) {
            throw e;
        }
    }

    public TestException() {
    }
}

class except2 extends Exception {
}