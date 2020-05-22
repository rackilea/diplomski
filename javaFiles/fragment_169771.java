import org.apache.spark.launcher.SparkAppHandle;
import org.apache.spark.launcher.SparkLauncher;

...

     public void startApacheSparkApplication(){
        SparkAppHandle handler = new SparkLauncher()
         .setAppResource("pathToYourSparkApp.jar")
         .setMainClass("your.package.main.Class")
         .setMaster("local")
         .setConf(...)
         .startApplication(); // <-- and start spark job app
     }
...