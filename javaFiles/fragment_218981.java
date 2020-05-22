@RunWith(Theories.class)
public class StaticFieldsUtilsTest {

  //your inner class with static fields


  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @DataPoint
  public static String FIELD1 = "Field1";
  @DataPoint
  public static String FIELD2 = "Field2";

  @Theory
  public void testViolations(String field){
    thrown.expect(IllegalArgumentException.class);
    StaticFieldsUtils.getPublicStaticFieldByName(field, StaticFieldContainer.class); 
  }
}