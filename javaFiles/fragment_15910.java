public interface ISpeak
{
   public String talk();
}

public class Dog implements ISpeak
{
   public String talk()
   {
        return "bark!";
   }
}

public class Cat implements ISpeak
{
    public String talk()
    {
        return "meow!";
    }
}