public class ExamDetails {

    static  StudentResults aStudent = new StudentResults();
    public static void main (String[] args){




        String sName = aStudent.fullName("Bill Gates");
        System.out.println(sName);

    }

    static class StudentResults{

    private String Full_Name;
    private String Exam_Name;
    private String Exam_Score;
    private String Exam_Grade;

    StudentResults(){
        Full_Name = "No Name Given";
        Exam_Name = "Unknown";
        Exam_Score = "No Score";
        Exam_Grade = "Unknown";
    }

    String fullName(String aName){

        Full_Name = aName;
        return Full_Name;

    }

}

}