@RunWith(ZohhakRunner.class)
public class PersonTest {

  @TestWith({"17, false", 
             "22, true" })
  public void shouldDecideAdulthood(int age, boolean expectedAdulthood) throws Exception {
    assertThat(new Person(age).isAdult(), is(expectedAdulthood));
  }
}