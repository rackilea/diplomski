/**
 * This class uses reflection to check whether {@link compareTo()} is being
 * called inside the add method after the test decides it is done with the
 * add method.
 * It will throw a {@link NotAllowedException}.
 *
 * @author yakatz <email@domain.com>
 */
private class MyIntWrapper {
    private boolean doneAdding = false;

    public void doneAdding() {
        this.doneAdding(true);
    }

    public void doneAdding(boolean b) {
        this.doneAdding = b;
    }

    private class MyInteger implements Comparable<MyInteger> {

        private Integer value;

        public MyInteger(int value) {
            this.value = value;
        }

        @Override
        public int compareTo(MyInteger o) {
            if (MyIntWrapper.this.doneAdding) {
                StackTraceElement[] causes = Thread.currentThread().getStackTrace();
                for (StackTraceElement cause : causes) {
                    if (cause.getClassName().equals("tree.Node") && cause.getMethodName().equals("add")) {
                        throw new NotAllowedException();
                    }
                }
            }
            return this.value.compareTo(o.value);
        }
    }
}