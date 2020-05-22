public class Example {
    public class BooleanResult {
        private boolean result;

        public void setResult(boolean value) { result = value; }
        public boolean getResult() { return result; }
    }

    // ....
    public List doSomething(BooleanResult out) {
        List list;
        boolean result;

        // ...

        out.setResult(result);

        return list;
    }
}