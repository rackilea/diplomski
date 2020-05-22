import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
  public static void main(String[] args) throws Exception {
    String json = "{ \"student_id\": \"123456789\", \"student_name\": \"Bart Simpson\", \"student_absences\": 1}";
    Student student = new ObjectMapper().readValue(json, Student.class);
    System.out.println(student);
  }
}

class Student {

  @JsonProperty("student_id")
  String studentId;

  @JsonProperty("student_name")
  String studentName;

  @JsonProperty("student_absences")
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