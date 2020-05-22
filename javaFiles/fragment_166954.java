public class TestClass {

public String baseUrl="http://www.indeed.co.uk";

//use this baseUrl in @test like below
@Test
public void Setup() {

driver.get(baseUrl);`
}