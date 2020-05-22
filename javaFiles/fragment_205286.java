import java.util.List;
import com.google.gson.Gson;

class Wrapper {
    boolean error;
    List<Lesson> lessons;

    //Getters & Setters
}

class Lesson {
    String id;
    String discipline;
    String type;
    String comment;

    //Getters & Setters
}

public class GsonSample {

    public static void main(String[] args) {
        String data = "{\"error\":false,\"lessons\":[{\"id\":1,\"discipline\":\"??????????\",\"type\":\"LECTURE\",\"comment\":\"no comments\"},{\"id\":2,\"discipline\":\"???. ??\",\"type\":\"LECTURE\",\"comment\":\"no comments\"}]}";

        Wrapper obj = new Gson().fromJson(data, Wrapper.class);
        System.out.println(obj.getLessons());
    }

}