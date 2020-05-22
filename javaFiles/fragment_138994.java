public enum Example {
    Object1("val1", "val2"), Object2("val3", "val4");

    private static final class ExampleValManager {
        static final Map<String, Example> EXAMPLE_VAL_MANAGER_MAP = new HashMap<>();
    }

    private String val1;

    private String val2;

    private Example(String val1, String val2) {
        this.val1 = val1;
        this.val2 = val2;
        ExampleValManager.EXAMPLE_VAL_MANAGER_MAP.put(val1, this);
    }

    public static Example getExampleByVal1(String val) {
        return ExampleValManager.EXAMPLE_VAL_MANAGER_MAP.get(val);
    }
}