@Rule
public ErrorCollector collector = new ErrorCollector();

@Test
public void testMethod()
{
   collector.checkThat(variable, equalTo(otherVaiable));
   collector.checkThat(variable2, equalTo(otherVaiable2));
}