class SuperClass
{
    public void onCreate()
    {
    System.out.println("Super");
    }
}

public class Apps extends SuperClass
{
    @Override
    public void onCreate()
    {
    super.onCreate();
    System.out.println("Sub");
    }

    public static void main(String[] args)
    {
    SuperClass supRef = new Apps();
    supRef.onCreate();
    }

}