public class SharedViewModel extends ViewModel {

  public void setAnswer(int questionId, String answer) {
    if(answers.get(questionId)!=null){
       answers.get(questionId).setValue(answer);
     }
   }
}