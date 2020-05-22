import scala.beans.BeanProperty

@Configuration
@ConfigurationProperties(prefix = "org-registry-list")
class OrgRegistryConfig() {
  @BeanProperty
  var organisations: Array[Organisation] = _
}

object OrgRegistryConfig {
  class Organisation() {
    @BeanProperty
    var orgId: Long = _
    @BeanProperty
    var orgName: String = _
  }
}