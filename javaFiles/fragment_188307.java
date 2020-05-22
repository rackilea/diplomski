import com.typesafe.config.ConfigFactory
  import scala.collection.JavaConverters._
  //load config into configTrialMap

configTrialMap.getObject("dummy")
  .keySet().asScala
  .map(k => {
    val k2 = k.replaceAll("\\.", "\".\"")  //quote all the dots in key
    ("dummy."+k2, configTrialMap.getStringList(s"dummy." + k2).asScala.toList)
  })
  .toMap