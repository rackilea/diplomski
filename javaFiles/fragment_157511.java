import akka.actor._
import java.net.InetSocketAddress
import akka.util.ByteString

class TCPServer(port: Int) extends Actor {

  override def preStart {
    IOManager(context.system).listen(new InetSocketAddress(port))
  }

  def receive = {
    case IO.NewClient(server) =>
      server.accept()
    case IO.Read(rHandle, bytes) => {
      val byteString = ByteString("HTTP/1.1 200 OK\r\n\r\nOK")
      rHandle.asSocket.write(byteString)
      rHandle.close()
    }
  }
}

object Application {
  def main(args: Array[String]) {
    val port = 8000
    ActorSystem().actorOf(Props(new TCPServer(port)))
  }
}