import java.lang.reflect.Type;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class GsonSimpleTest {

    public static class Person {
        public int id;
        public String name;
        public Person parent;

        public Person(final int id, final String name) {
            super();
            this.id = id;
            this.name = name;
        }

        public Person(final int id, final String name, final Person parent) {
            super();
            this.id = id;
            this.name = name;
            this.parent = parent;
        }

        public int getId() {
            return id;
        }

        public void setId(final int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(final String name) {
            this.name = name;
        }

        public Person getParent() {
            return parent;
        }

        public void setParent(final Person parent) {
            this.parent = parent;
        }

    }

    public static class PersonSerializer implements JsonSerializer<Person> {
        public JsonElement serialize(final Person person, final Type type, final JsonSerializationContext context) {
            JsonObject result = new JsonObject();
            result.add("id", new JsonPrimitive(person.getId()));
            result.add("name", new JsonPrimitive(person.getName()));
            Person parent = person.getParent();
            if (parent != null) {
                result.add("parent", new JsonPrimitive(parent.getId()));
            }
            return result;
        }
    }

    public static void main(final String[] args) {
        Person p = new Person(1, "Joe", new Person(2, "Mike"));
        com.google.gson.Gson gson = new GsonBuilder().registerTypeAdapter(Person.class, new PersonSerializer())
                .create();
        System.out.println(gson.toJson(p));
    }

}