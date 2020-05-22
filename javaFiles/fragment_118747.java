fun main() {
   val uri = "tcp://localhost:3006"
   val context = ZContext(1)
   val socket = context.createSocket(SocketType.SUB)

   socket.hwm = 10000
   socket.receiveTimeOut = 250

   "connecting to $uri".log()
   socket.bind(uri)

   socket.subscribe("/some/feed")

   while (true) {
      val path = socket.recvStr() ?: continue
      val bytes = socket.recv()
      val msg = Msg.parseFrom(bytes)
      "<< $path | ${msg.json()}".log()
   }
}