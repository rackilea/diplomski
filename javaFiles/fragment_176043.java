public class Survey{
    protected ArrayList<EssayQuestion> questionList;

    //your parent class methods;
}


public class Test extends Survey
{
  public ArrayList<Answer> answerList = new ArrayList<Answer>();

  public Test(){
    questionList = new ArrayList<EssayQuestion>(); //Option 1
  }

  public void createNewQuestion(){
    //If you've not initialized it in the constructor, try instantiating it in on first use
    if(questionList == null){ //Option 2
        questionList = new ArrayList<EssayQuestion>();
    }

    //now you can access the questionList without an exception.
    //this is because you've a valid instance of of ArrayList<EssayQuestion> to which the
    //variable questionList points to
  }
}