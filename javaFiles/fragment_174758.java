import java.io.FileInputStream;
import java.io.IOException;

public class Grader {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("replies.txt"));
        Student student = new Student();
        String reply = student.prompt();
        assert reply.equals("reply");
    }
}