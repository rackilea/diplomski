public class ClassName {
    private String username;
    private person[] persons;

    public ClassName(String username, person[] persons) {
        this.username = username;
        this.persons = persons;
    }

    public static void main(String[] args) {
        Gson gson = new Gson();
        String jsonStr;
        // To parse json string :
        ClassName className = gson.fromJson(jsonStr, ClassName.class);

        // using json file
        ClassName className = gson.fromJson(new FileReader("path to file"), ClassName.class);
    }
}

class Person {
    private int id;
    private string name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }
}