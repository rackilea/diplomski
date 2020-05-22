import java.io.*;

class attendance_and_student_management {
    public static void main(String[] args) {
        BufferedReader bw = new BufferedReader(new InputStreamReader(System.in));

        File f5 = new File("e.txt");
        f5.createNewFile();
        File f4 = new File("d.txt");
        f4.createNewFile();
        File f3 = new File("c.txt");
        f3.createNewFile();
        File f2 = new File("b.txt");
        f2.createNewFile();
        File f1 = new File("a.txt");
        f1.createNewFile();
    }
}