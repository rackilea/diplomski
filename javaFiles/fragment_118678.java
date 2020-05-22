public class Sample {

  public static void main(String[] args) {
    Questions question = new Questions();
    question.setId(101);
    question.setQuestion("Random Question");

    Set<String> answer= new HashSet<String>();
    answer.add("random answer1");
    answer.add("random answer2");

    question.setAnswers(answer);

    //Similarly invoke getXXX to get the values
  }

}