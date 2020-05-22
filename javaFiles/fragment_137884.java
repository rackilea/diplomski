fun main() {
    var hello = "Hello"
    var message = thisTakesTime()
    println("The message is $hello $message")
    println(hello)
}

fun thisTakesTime(): String {
    // do something that takes 1 second (1000 ms)
    Thread.sleep(1000)
    return "World"
}