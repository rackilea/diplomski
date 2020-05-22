public class Question {

private List<Object> list;

public Question(List<Object> list) {
this.list = list;
}
public Question() {
//do nothing
}

@Override
public String toString() {
String str = "";
for (int i = 0; i < list.size(); i++) {
    str += list.get(i).toString() + " ";
}
return str;
}


public int answer() {
int theAnswer = (int) calculationl(this.toString());
System.out.println("The correct answer answer is " + theAnswer);
return theAnswer;
}}