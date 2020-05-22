@Singleton
@Startup
public class TaskSingleton {

  @Schedule(second = "0", minute = "*/15", hour = "*")//This mean each 15:00 minutes
  public void getTemplateNames() {
    // YOUR TASK IMPLEMENTATION HERE
  }
}