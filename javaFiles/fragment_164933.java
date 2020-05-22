public class Test {
    public static void main(String args[]) {
            Test t = new Test();
            t.testException();
            t.testBoolean();
    }
    public void testException() {
            long start = System.currentTimeMillis();
            for(long i = 0; i <= 10000000L; ++i)
                    doSomethingException();
            System.out.println("Exception:" + (System.currentTimeMillis()-start) + "ms");
    }
    public void testBoolean() {
            long start = System.currentTimeMillis();
            for(long i = 0; i <= 10000000L; ++i)
                    doSomething();
            System.out.println("Boolean:" + (System.currentTimeMillis()-start) + "ms");
    }

    private void doSomethingException() {
        try {
          doSomethingElseException();
        } catch(DidNotWorkException e) {
           //Msg
        }
    }
    private void doSomethingElseException() throws DidNotWorkException {
       if(!isSoAndSo()) {
          throw new DidNotWorkException();
       }
    }
    private void doSomething() {
        if(!doSomethingElse())
            ;//Msg
    }
    private boolean doSomethingElse() {
       if(!isSoAndSo())
          return false;
       return true;
    }
    private boolean isSoAndSo() { return false; }
    public class DidNotWorkException extends Exception {}
}