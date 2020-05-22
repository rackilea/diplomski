@RunWith(PowerMockRunner.class)
@PrepareForTest(StatementUtility.class)
public class DBConnectionBTBAdminTest {


    @Test
    public void deleteTest() {

        PowerMockito.mockStatic(StatementUtility.class);

        List<String> testInput = new ArrayList<>();
        testInput.add("hello");
        testInput.add("World");

        Driver driver = new Driver();
        Connection conn = driver.connectCustomerDB(testInput);

        String query = "FooBarFooBarFooBarFooBarFooBarFooBarFooBarFooBar";

        try {
           BDDMockito.given(StatementUtility.getFoo(...)).willReturn(...);

            ...
        } catch (SQLException e) {
            ...
        }
    }
}