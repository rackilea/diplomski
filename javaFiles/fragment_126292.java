class Employee{

    public Employee(String name){
        this.name= name;
    }
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class GsonTest {
    public static void main(String[] args) {
        Gson gson = new Gson();
        Employee employee=new Employee("Amit");
        String s=gson.toJson(employee, Employee.class);
        System.out.println(s);
        JsonElement jsonElement = gson.toJsonTree(employee);
        jsonElement.getAsJsonObject().addProperty("dept", "IT");
        s=gson.toJson(jsonElement);
        System.out.println(s);
    }

/** Output
{"name":"Amit"}
{"name":"Amit","dept":"IT"}
*/