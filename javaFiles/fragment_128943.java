class Vader extends Actor {
    def receive {
        case p@Process => ...
        case Ignore => context.become(ignore) //changes message handler to `ignore`
    }


    def ignore = {
        case x => println("Ignored message " + x)
        case UnIgnore => context.become(process)//changes message handler back
    }

}