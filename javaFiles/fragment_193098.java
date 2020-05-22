public class MyFirstPojo
{
    private String name;

    public static void main(String [] args)
    {
       for (String arg : args)
       {
          MyFirstPojo pojo = new MyFirstPojo(arg);  // Here's how you create a POJO
          System.out.println(pojo); 
       }
    }

    public MyFirstPojo(String name)
    {    
        this.name = name;
    }

    public String getName() { return this.name; } 

    public String toString() { return this.name; } 
}