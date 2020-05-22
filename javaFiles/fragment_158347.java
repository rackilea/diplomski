public class Quizmodel {

String mAnswer = new String();
String mQuestion = new String();
List<String> mOptions = new ArrayList<>();
public String getmQuestion() {
        return mQuestion;
    }

    public void setmQuestion(String mQuestion) {
        this.mQuestion = mQuestion;
    }

public String getmAnswer() {
        return mAnswer;
    }

    public void setmAnswer(String mAnswer) {
        this.mAnswer= mAnswer;
    }





    public List<String> getmOptions() {
        return mOptions;
    }

    public void setmOptions(List<String> mOptions) {
        this.mOptions = mOptions;
    }
    }