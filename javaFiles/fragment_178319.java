class Person {

    private String name;

    public Person(String name){
        this.name = name;
    }

    public Person(Person p){
        this.name = p.name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class MainProg {
    public static void main(String[] args) {
        Person t1 = new Person("Joe");
        Person t2 = new Person("John");
        System.out.println(t1.getName());
        System.out.println(t2.getName());
        t1.setName("Mark");
        System.out.println(t1.getName());
        System.out.println(t2.getName());
        Person t3 = new Person(t1);
        System.out.println(t3.getName());
    }
}