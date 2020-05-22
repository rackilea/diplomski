import android.app.Application

class TestApp : Application() {
    override fun onCreate() {
        super.onCreate()

        val exceptionHandler = SimpleExceptionHandler()
        Thread.setDefaultUncaughtExceptionHandler(exceptionHandler)
    }
}


class SimpleExceptionHandler : Thread.UncaughtExceptionHandler {
    override fun uncaughtException(thread: Thread, exc: Throwable) {
        // Log your exception here to files, database, etc together with the device status like RAM, processes, network condition that the crash point 
    }
}