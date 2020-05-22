abstract class Parent 
{
     abstract public void parentMethod();
}

class ChildClass extends Parent
{
    @Override
    public void parentMethod()
    {
        System.out.println("Child method");
    }
 }