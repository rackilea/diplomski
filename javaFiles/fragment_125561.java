package jerceka.workhard.demo;

@Entity
public class Account {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int age;

    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "Account [Name=" + this.anme + ", Age=" + this.age + "]";
    }
}