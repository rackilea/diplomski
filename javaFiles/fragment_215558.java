public class Step1 {
    private Bean1 bean1;
    private Bean2 bean2;

    private final String someValue;
    private final String someOtherValue;

    public Step(String someValue, String someOtherValue) {
        this.someValue = someValue;
        this.someOtherValue = someOtherValue;
    }

    @Autowired
    public void setBean1(Bean1 bean1) {
        this.bean1 = bean1;
    }

    @Autowired
    public void setBean2(Bean2 bean2) {
        this.bean2 = bean2;
    }

    do() {
        // ...
    }
}