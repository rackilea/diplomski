package test;

public class right implements iright
{
    public right(iright f)
    {
        System.out.println("right side constructed... ");
    f.announceMyself();
    }

    public void announceMyself()
    {
        System.out.println("Hello from the right side...");  
    }    
}