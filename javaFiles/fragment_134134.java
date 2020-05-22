class MainApplication : Application() {
    companion object {
        @JvmStatic fun get(context: Context): MainApplication {
            return context.applicationContext as MainApplication
        }
    }
}