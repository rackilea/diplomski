fun main() {
   val uri = "tcp://localhost:3006"
   val context = ZContext(1)
   val socket = context.createSocket(SocketType.PUB)

   socket.hwm = 10000
   socket.linger = 0
   "connecting to $uri".log()
   socket.connect(uri)

   fun publish(path: String, msg: Msg) {
      ">> $path | ${msg.json()}".log()
      socket.sendMore(path)
      socket.send(msg.toByteArray())
   }

   var count = 0

   while (notInterrupted()) {
      val msg = telegramMessage("message : ${++count}")
      publish("/some/feed", msg)
      println()

      sleepInterruptible(1.second)
   }
}