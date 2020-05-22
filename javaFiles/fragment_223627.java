import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static String HEADER_DELIMITER = ",";
    private static String DATA_DELIMITER = ",";

    public static void main(String[] args) {
        /**
         * for each file read lines and then ...
         */
        String headerLine = "id,name,family";
        String[] otherLines = { "1,A,B", "2,C,D" };
        List<Student> students = new ArrayList<Student>();
        String[] titles = headerLine.split(HEADER_DELIMITER);
        for (String line : otherLines) {
            String[] cells = line.split(DATA_DELIMITER);
            Student student = new Student();
            int i = 0;
            for (String cell : cells) {
                student.add(titles[i], cell);
                i++;
            }
            students.add(student);
        }
        System.out.println(students);
        /*
         * output:
         * [Student [data={id=1, family=B, name=A}], Student [data={id=2, family=D, name=C}]]
         */

        /**
         * save students in your table.
         */
    }

    static class Student {
        Map<String, String> data = new HashMap<String, String>();

        public void add(String key, String value) {
            data.put(key, value);
        }

        @Override
        public String toString() {
            return "Student [data=" + data + "]";
        }
    }
}