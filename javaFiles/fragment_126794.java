fun createTask(): () -> Unit {
    return {
        println("Hello world")
    }
}

fun createExecutor() : (() -> Unit) -> Unit {
    return { task: () -> Unit ->
        println("I'm going to execute the task...")
        task()
        println("I'm going to execute the task a second time...")
        task()
    }
}

fun main(args: Array<String>) {
    val task = createTask()
    val executor = createExecutor()
    executor(task)
}