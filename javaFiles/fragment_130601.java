import java.io.File;
   import java.io.IOException;
   import java.math.BigDecimal;
   import java.math.BigInteger;
   import java.util.LinkedList;
   import java.util.List;
   import java.util.StringTokenizer;
   import java.util.function.Consumer;
   import java.util.logging.Level;
   import java.util.logging.Logger;
   import java.util.stream.Stream;

   public class Student {

private int idStudent;
private String name;
private BigDecimal ir101Mark;
private BigDecimal ir102Mark;
private BigDecimal agregateMark;

public int getIdStudent() {
    return idStudent;
}

public void setIdStudent(int idStudent) {
    this.idStudent = idStudent;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public BigDecimal getIr101Mark() {
    return ir101Mark;
}

public void setIr101Mark(BigDecimal ir101Mark) {
    this.ir101Mark = ir101Mark;
}

public BigDecimal getIr102Mark() {
    return ir102Mark;
}

public void setIr102Mark(BigDecimal ir102Mark) {
    this.ir102Mark = ir102Mark;
}

public BigDecimal getAgregateMark() {
    return agregateMark;
}

public void setAgregateMark(BigDecimal agregateMark) {
    this.agregateMark = agregateMark;
}

public static List<Student> getStudentList(java.io.File irStudentsFile){

    List<Student> students = new LinkedList<>();
    Stream<String> lines;
    try {
        lines = java.nio.file.Files.lines(irStudentsFile.toPath());
    } catch (IOException ex) {
        return null;
    }

    lines.forEach((Consumer<? super String>) line -> 
        {
            Student student = new Student();
            StringTokenizer sToken = new StringTokenizer(line, " ");
            student.setIdStudent(Integer.valueOf(sToken.nextToken()));
            student.setName(sToken.nextToken());

            students.add(student);
        } 

    );

    return students;
}

public static void setIR101Mark(java.io.File ir101File, List<Student> students){
    Stream<String> lines;
    try {
        lines = java.nio.file.Files.lines(ir101File.toPath());
    } catch (IOException ex) {
        return;
    }

    lines.forEach((Consumer<? super String>) new Consumer<String>() {

        @Override
        public void accept(String line) {
            Student student = null;
            StringTokenizer sToken = new StringTokenizer(line, " ");
            int idStudent = Integer.valueOf(sToken.nextToken());

            for (Student student1 : students) {
                if (student1.getIdStudent() == idStudent) {
                    student = student1;
                }
            }

            if (student == null) {
                return;
            }

            student.setIr101Mark(BigDecimal.valueOf(Double.valueOf(sToken.nextToken())));
        }
    }
    );
}

public static void setIR102Mark(java.io.File ir102File, List<Student> students){
    Stream<String> lines;
    try {
        lines = java.nio.file.Files.lines(ir102File.toPath());
    } catch (IOException ex) {
        return;
    }

    lines.forEach((Consumer<? super String>) new Consumer<String>() {

        @Override
        public void accept(String line) {
            Student student = null;
            StringTokenizer sToken = new StringTokenizer(line, " ");
            int idStudent = Integer.valueOf(sToken.nextToken());

            for (Student student1 : students) {
                if (student1.getIdStudent() == idStudent) {
                    student = student1;
                }
            }

            if (student == null) {
                return;
            }

            student.setIr102Mark(BigDecimal.valueOf(Double.valueOf(sToken.nextToken())));
        }
    }
    );
}

public static void agregateMark(List<Student> students){
    students.forEach(student ->{
        BigDecimal agregate = 
                student.getIr101Mark()
                .add(student.getIr102Mark())
                .divide(BigDecimal.valueOf(Double.valueOf(2)));

        student.setAgregateMark(agregate);
    });
}

public static void main(String args[]){
    File irStudentFile = new File("D:\\IRstudent.txt");
    File ir101File = new File("D:\\IR101.txt");
    File ir102File = new File("D:\\IR102.txt");
    List<Student> students = Student.getStudentList(irStudentFile);
    Student.setIR101Mark(ir101File, students);
    Student.setIR102Mark(ir102File, students);
    Student.agregateMark(students);



    System.out.println("*** List of students ***");
    students.forEach(student -> {
        System.out.println("id: " + student.getIdStudent());
        System.out.println("Name: " + student.getName());
        System.out.println("IR 101 Mark: " + student.getIr101Mark());
        System.out.println("IR 102 Mark: " + student.getIr102Mark());
        System.out.println("Agregate Mark: " + student.getAgregateMark());
        System.out.println("----------------------------------------------");
    });
}