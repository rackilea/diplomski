@Component
class GlobalValue {
    companion object {
        @JvmStatic
        lateinit var database: String
        @Value("\${myprop.testing2}") set
    }
}