public class MathProblemTest {

  private MathProblem mathProblem;

  @Before
  public void before() throws Exception {
    mathProblem = new MathProblem();
  }

  @Test
  public void testGetUserAnswer() throws Exception {
    StringBuilder sb = new StringBuilder();
    sb.append("41 20");
    String data = sb.toString();
    System.setIn(new ByteArrayInputStream(data.getBytes()));

    mathProblem.setUserAnswer();

    assertThat(mathProblem.getUserAnswer(), equalTo(41));
  }

}