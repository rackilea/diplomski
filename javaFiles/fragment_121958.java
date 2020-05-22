public enum PaymentType {
    FOO("Some label for foo", true),
    BAR("Some label for bar", false),
    BAZ("Some label for baz", true);

    private String label;
    private boolean required;

    private PaymentType(String label, boolean required) {
        this.label = label; 
        this.required = required;
    }

    public String getLabel() { 
        return label;
    }

    public boolean isRequired() {
        return required;
    }
}