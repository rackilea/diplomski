public class StudentProgress implements Comparable<StudentProgress> {

    String name;
    String grade;
    char baseGrade;    // Just the letter
    int gradeModifier; // -1 0 or +1 - done to make sorting easier

    public StudentProgress( String name, String grade ) {
        this.name = name;
        this.grade = grade;
        // Extract the grade parts for use when comparing
        baseGrade = grade.charAt( 0 );
        gradeModifier = grade.length() == 1 ? 0 : Integer.parseInt( grade.charAt( 1 ) + "1" );
    }

    public int compareTo( StudentProgress o ) {
        return baseGrade == o.baseGrade ? gradeModifier - o.gradeModifier : baseGrade - o.baseGrade;
    }
}