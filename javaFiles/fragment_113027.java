@Configuration
@ConfigurationProperties(value =  "my")
class TenantProperties {

    lateinit var code: String
    lateinit var id: String
    lateinit var name: String

    val db = DatabaseProperties()

    inner class DatabaseProperties {
        lateinit var uriTemplate: String
        lateinit var username: String
        lateinit var password: String
        val connectionString by lazy { "$uriTemplate".format(username, password, code) }
    }
}