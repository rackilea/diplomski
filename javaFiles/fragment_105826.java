import kotlinx.coroutines.experimental.*
import kotlin.coroutines.experimental.*

fun main(args: Array<String>) {
    var continuation: Continuation<Unit>? = null
    println("main(): launch")
    GlobalScope.launch(Dispatchers.Unconfined) {
        println("Coroutine: started")
        suspendCoroutine<Unit> {
            println("Coroutine: suspended")
            continuation = it
        }
        println("Coroutine: resumed")
    }
    println("main(): resume continuation")
    continuation!!.resume(Unit)
    println("main(): back after resume")
}