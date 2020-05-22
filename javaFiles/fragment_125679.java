public class Student {

    String name = "Student" + Math.random()*100;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}