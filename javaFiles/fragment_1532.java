import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class JsonApp {

    public static void main(String[] args) throws Exception {
        Marks marks = new Marks();
        Students student0 = new Students(1, "Rick", marks);
        Students student1 = new Students(2, "Morty", marks);

        marks.setMarksId(1);
        marks.setMarkValue("Value");
        marks.setStudents(new HashSet<>(Arrays.asList(student0, student1)));

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        System.out.println(mapper.writeValueAsString(student0));
        System.out.println(mapper.writeValueAsString(student1));
        System.out.println(mapper.writeValueAsString(marks));
    }
}