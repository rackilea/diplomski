public class Launcher
{
    public static void main(String args)
    {
       Strategy s = new UselessStrategy();
          //OR Strategy s = CreateInstance(args[0]) ;
          //OR equiv mechanism for Dependency Injection if you don't want to hardcode the derived strategy to use.
        s.execute(new SoccerRobot())
    }
}