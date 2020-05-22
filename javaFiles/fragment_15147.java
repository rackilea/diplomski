@Component
class GlobalValue {
    companion object {
        @JvmField
        var database: String = "test"
    }

    @Value("\${myprop.testing2}")
    fun setDatabase(db: String) {
        database = db
    }
}