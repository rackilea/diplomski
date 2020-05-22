public class Grades {
private int len;
private String [] gradeNames;
private int [] gradeArray;

private int enterGradeNames(){
    Scanner input = new Scanner(System.in);
    for (int i = 0; i < len; i++){
        System.out.println("Enter the type of grades you will be reporting: (" + 
                (i + 1) + " of " + gradeArray.length + ")" );
        gradeNames[i] = new String(input.next());
    }
    return 0;
}

public Grades(int length){
    this.len = length;
    gradeArray = new int[len];
    gradeNames = new String[len];
}