// Integrate Sniffy to your test using @Rule annotation and a QueryCounter field
@Rule
public final QueryCounter queryCounter = new QueryCounter();

// Now just add @Expectation or @Expectations annotations to define number of queries allowed for given method
@Test
@Expectation(1)
public void testJUnitIntegration() throws SQLException {
    // Just add sniffer: in front of your JDBC connection URL in order to enable sniffer
    final Connection connection = DriverManager.getConnection("sniffer:jdbc:h2:mem:", "sa", "sa");
    // Do not make any changes in your code - just add the @Rule QueryCounter and put annotations on your test method
    connection.createStatement().execute("SELECT 1 FROM DUAL");
}