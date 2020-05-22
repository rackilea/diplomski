public class Person {
private String name;
private String gender;
private int age;
Person(String name, String gender, int age){
    this.name = name;
    this.gender = gender;
    this.age = age;
}
public void setName(String name){
    this.name = name;
}
public void setGender(String gender){
    this.gender = gender;
}
public void setAge(int age){
    this.age = age;
}
public String getName(){
    return this.name;
}
public String getGender(){
    return this.gender;
}
public int getAge(){
   return this.age;
}
public static void main(String[] args)
{
    Person me = new Person("MyName","male",20);
    System.out.println("My name is:" + me.getName());
    me.setName("OtherName");
    System.out.println("My name is:" + me.getName());
}
}