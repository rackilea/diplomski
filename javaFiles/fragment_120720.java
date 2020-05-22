import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

public class PersonExample {
  public static void main(String... args) {
    InputStreamReader streamReader = new InputStreamReader(
        PersonExample.class.getResourceAsStream("/test.json"));

    PeopleWrapper wrapper = parseJSON(streamReader);
    System.out.println(wrapper.people);
  }

  public static class PeopleWrapper {
    @SerializedName("people")
    public List<Person> people;
  }

  public static PeopleWrapper parseJSON(Reader jsonInput) {
    GsonBuilder builder = new GsonBuilder();
    builder.registerTypeAdapter(Person.class, new PersonTypeAdapter());
    Gson gson = builder.create();

    PeopleWrapper peopleWrapper = gson.fromJson(jsonInput, PeopleWrapper.class);

    return peopleWrapper;
  }
}