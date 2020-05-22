import org.apache.spark.launcher.SparkAppHandle;
import org.apache.spark.launcher.SparkLauncher;

   public class MyLauncher {
     public static void main(String[] args) throws Exception {
       SparkAppHandle handle = new SparkLauncher()
         .setAppResource("/my/scala.jar")
         .setMainClass("my.spark.app.Main")
         .setMaster("local")
         .setConf(SparkLauncher.DRIVER_MEMORY, "2g")
         .startApplication();
       // Use handle API to monitor / control application.
     }
   }