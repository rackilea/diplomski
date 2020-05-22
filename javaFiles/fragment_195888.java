class BusbyMoviesMainApplication : Application() {
    companion object {
        private lateinit var instance: BusbyMoviesMainApplication

        @JvmStatic
        fun getBusbyInstance() = instance
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}