public class MathProblem {

  private int userAnswer;

  public void setUserAnswer(){
    Scanner input = new Scanner(System.in);
    userAnswer = input.nextInt();
  }

  public int getUserAnswer() {
    return userAnswer;
  }
}