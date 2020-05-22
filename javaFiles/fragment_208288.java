import java.io.File

import play.api._
import com.typesafe.config.ConfigFactory

object Global extends GlobalSettings {
  override def onLoadConfig(config: Configuration, path: File, classloader:         ClassLoader, mode: Mode.Mode): Configuration = {
    val env = System.getProperty("environment")
    val envConfig = config ++ Configuration(ConfigFactory.load(s"application.${environment}.conf"))
    super.onLoadConfig(environmentSpecificConfig, path, classloader, mode)
  }
}