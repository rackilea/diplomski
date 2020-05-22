public class BarWrapper {
    private Bar bar;

    public Boolean getFoo() {
        return this.bar.getFoo();
    }

    public void setFoo(final Boolean value) {
        this.bar.setFoo(value);
    }
}