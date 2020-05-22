class ServerSettings(settings: String) {
    val resources = Properties()

    init {
        val fileUrl: URL = resources.javaClass.getResource("/$settings.properties")
                ?: throw FileNotFoundException("$settings.properties file not found")
        fileUrl.openStream().use { resources.load(it) }
    }

    fun printSettings() = resources.stringPropertyNames().forEach {
        println("Property: $it has value: '${resources[it]}'")
    }

    fun getString(key: String): String = resources[key]!! as String

    fun getInt(key: String): Int = (resources[key]!! as String).toInt()
}