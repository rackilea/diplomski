public class Main 
{
    public static void main(String[] args) 
    {    

        Human bob = new Human("bob");
        System.out.println(bob.name);
    }      

}

class Human
{
    public String name;
    public Human(String name)
    {
        this.name = name;
    }
}