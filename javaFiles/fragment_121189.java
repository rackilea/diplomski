case object Inc

class IncrementingActor extends Actor {
    var i = 0

    protected def receive = {
        case Inc =>
            i += 1
            sender ! i
    }
}