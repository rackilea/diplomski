/*
 * used to get the path of necessary resources 
 */
  public class AppConstant {

  // prevents instantiation
  private AppConstant () { 

 } 

  public static final String CURRENT_DIR = System.getProperty("user.dir");
  public static final String APP_RESOURCE = CURRENT_DIR+"/resources/";  
 }