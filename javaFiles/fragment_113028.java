@Configuration
@ConfigurationProperties(value =  "my", ignoreUnknownFields = false, ignoreInvalidFields = false)
class TenantProperties {

    @NotNull lateinit var code: String
    @NotNull lateinit var id: String
    @NotNull lateinit var name: String

    val db = DatabaseProperties()

    inner class DatabaseProperties {
        @NotNull lateinit var uriTemplate: String
        @NotNull lateinit var username: String
        @NotNull lateinit var password: String
        val connectionString by lazy { "$uriTemplate".format(username, password, code) }
    }
}