public class HelloWorld 
{
    public static void main(String[] args)
    {
        OtherClass myObject = new OtherClass(7);
        OtherClass yourObject = new OtherClass(4);
        yourObject.value = 23;
        System.out.print(myObject.compareTo(yourObject));
    }
}

public class OtherClass
{
    private int value;
    OtherClass(int value) 
    {
        this.value = value; 
    }  

    public int compareTo(OtherClass c) 
    {
        return this.value - c.value;
    }  
}