blocking-dispatcher {
    type = PinnedDispatcher 

    executor = "thread-pool-executor"
    thread-pool-executor {
        core-pool-size-min = 2 <----- Since you're using a PinnedDispatcher, it only uses 1 thread
        core-pool-size-factor = 2.0 <----- same here
        core-pool-size-max = 10 <----- same here
    } <--- PinnedDispatcher will automatically make it 1 thread: https://github.com/akka/akka/blob/master/akka-actor/src/main/scala/akka/dispatch/PinnedDispatcher.scala#L27
    throughput = 100
    mailbox-capacity = -1
    mailbox-type =""
}