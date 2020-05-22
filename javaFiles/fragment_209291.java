import akka.actor.ActorSystem
import com.typesafe.config.ConfigFactory

val customConf = ConfigFactory.parseString("""
  akka.actor.deployment {
    /my-service {
      router = round-robin
      nr-of-instances = 3
    }
  }
""")

// ConfigFactory.load sandwiches customConfig between default reference
// config and default overrides, and then resolves it.
val system = ActorSystem("MySystem", ConfigFactory.load(customConf))