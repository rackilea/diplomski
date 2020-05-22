import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class Main {
  public static void main(String[] args) {
    String json = "{ \"student_id\": \"123456789\", \"student_name\": \"Bart Simpson\", \"student_absences\": 1}";
    Student student = new Gson().fromJson(json, Student.class);
    System.out.println(student);
  }
}

class Student {

  @SerializedName("student_id")
  String studentId;

  @SerializedName("student_name")
  String studentName;

  @SerializedName("student_absences")
  Integer studentAbsences;

  @Override
  public String toString() {
    return "Student{" +
      "studentId='" + studentId + '\'' +
      ", studentName='" + studentName + '\'' +
      ", studentAbsences=" + studentAbsences +
      '}';
  }
}