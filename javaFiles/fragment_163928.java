class TestResponse {

    @SerializedName("test-run")
    private TestRun testRun;

    // other properties, getters, setters, toString
}

class TestRun {

    @SerializedName("test-suite")
    private List<TestSuite> testSuite;

    // other properties, getters, setters, toString
}

class TestSuite {
    private String result;
    private double duration;

    @SerializedName("test-suite")
    private List<TestSuite> testSuites;

    @SerializedName("test-case")
    private List<TestCase> testCases;

    // other properties, getters, setters, toString
}

class TestCase {

    private String fullname;

    // other properties, getters, setters, toString
}