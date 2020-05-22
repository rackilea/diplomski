public class Main extends JavaPlugin{
  public static Main plugin; //create the variable

  @Override
  public void onEnable(){
    plugin = this; //assign plugin to this class
    //other onEnable things
  }

  @Override
  public void onDisable(){
    //onDisable things
    plugin = null; //best to put this AFTER running any methods here
  }
}