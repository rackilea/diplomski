public class Test {

    public static void main(String[] args) {

        Person array[] = {new Person("Jason", "123456"), new Person("Karl", "78945"), new Person("Tom", "789456")};

        for(int i = 0; i < array.length; i++){
            array[i].toString();
            //System.out.println(array[i].toString());
        }
    }

}

class Person
{
    private String name;
    private String phoneNumber;

    public Person(String name, String phoneNumber)
    {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    public String getName()
    {
        return name;
    }
    public String getNumber()
    {
        return phoneNumber;
    }
    public String getPerson()
    {
        return name + " " + phoneNumber;
    }
    @Override
    public String toString()
    {
        return "["+getPerson()+"]";
    }
}