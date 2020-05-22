public class SubClassN extends BaseClass {
    private Integer index;

    public SubClassN(Integer index) {
        this.index = index;
    }

    @Override
    public void doSomething() {
        say("SubClass" + index + ": doSomething() called.");
    }

    public Integer getIndex() {
        return index;
    }
}