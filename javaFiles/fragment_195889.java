class BusbyMoviesMainApplication : Application() {
    companion object {
        @JvmStatic
        lateinit var instance: BusbyMoviesMainApplication
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}