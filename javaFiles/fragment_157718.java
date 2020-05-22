import java.io.FileReader;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Foo
{
  public static void main(String[] args) throws Exception
  {
    Gson gson = new GsonBuilder().setDateFormat("MM/dd/yyyy hh:mm").create();

    SuperClass sc = gson.fromJson(new FileReader("input.json"), SuperClass.class);
    System.out.println(gson.toJson(sc));
    // {"name":"0","dtExpiration":"07/14/2011 12:00","question_array":[{"question":0,"questionType":"resposta de texto","min":"null","max":"null","responceList":[],"answer_array":[{"id":1,"answer":"yes"},{"id":2,"answer":"no"}]}]}
  }
}

class SuperClass
{
  String name;
  Date dtExpiration;
  List<String> quotaList;
  Question[] question_array;
}

class Question
{
  int question;
  String questionType;
  String min;
  String max;
  List<String> responceList;
  Answer[] answer_array;
}

class Answer
{
  int id;
  String answer;
}