// MyValueClass.java
public class MyValueClass {

    private final String value;

    public MyValueClass(String v) {
        this.value = v;
    }

    public String getValue() {
        return value;
    }
}

// snippet from MySteps.java
@Given("^a table with$")
public void a_table_with(DataTable arg1) throws Throwable {
    System.out.println(arg1.asLists(MyValueClass.class));
}

// snippet from my test1.feature
  Scenario: Test with Datatable
    Given a table with
      | a | b | c |
      | 1 | 2 | 3 |
      | a | b | c |