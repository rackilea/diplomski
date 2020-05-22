import play.api._  
import play.api.Logger  
import com.typesafe.config.ConfigFactory   
import java.io.File 

 object Global extends GlobalSettings {    

      override def onLoadConfig(config: Configuration, path: File, classloader:     ClassLoader,mode: Mode.Mode): Configuration = {

    Logger.info("Application  configuration file is loading with " + mode.toString + "  mode")

    val modeSpecificConfig = config ++ Configuration(ConfigFactory.load(s"${mode.toString.toLowerCase}.conf"))
    super.onLoadConfig(modeSpecificConfig, path, classloader, mode)

  }
}