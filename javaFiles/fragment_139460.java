public class SurveyTest extends TestCase {

private Survey survey;

protected void setUp() throws Exception {
    super.setUp();  
    survey = new Survey();
}

public void testSurvey() {
    survey.toString();
}

public void testSurveyLongString() {
    fail("Not yet implemented");
}

public void testGetId() {
    long expected = (long) Math.random();
    survey.setId(expected);
    long actual = survey.getId();
    Assert.assertEquals(expected, actual);
}

public void testGetTitle() {
    String expected = "surveytitle";
    survey.setTitle(expected);
    String actual = survey.getTitle();
    Assert.assertEquals(expected, actual);  
}

public void testIsActive() {
    Boolean expected = true;
    survey.setActive(expected);
    Boolean actual = survey.isActive();
    Assert.assertEquals(expected, actual);
}

public void testGetQuestions() {
    fail("Not yet implemented");
}

}