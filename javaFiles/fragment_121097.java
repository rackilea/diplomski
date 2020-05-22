import scala.concurrent.{Future, Await}
import scala.concurrent.duration._
import scala.util.Try
import scala.concurrent._
import java.util.concurrent.Executors

implicit val ec = ExecutionContext.fromExecutor(Executors.newFixedThreadPool(100)) 

def openPorts(address:String ="127.0.0.1",duration:Duration = 10 seconds, fromPort:Int = 1, toPort:Int = 65536) = {
 val socketTimeout = 200
 val result = Future.traverse(fromPort to toPort ) { port =>
  Future{ Try {
    val socket = new java.net.Socket()
    socket.connect(new java.net.InetSocketAddress(address, port),socketTimeout)
    socket.close()
    port
  } toOption } 
 } 
 Try {Await.result(result, duration)}.toOption.getOrElse(Nil).flatten
}


scala> val localPorts openPorts(fromPort = 10, toPort = 1000)
localPorts: scala.collection.immutable.IndexedSeq[Int] = Vector(22, 631)
scala> val remotePorts = openPorts(fromPort = 10, toPort = 1000, address="192.168.1.20")
remotePorts: scala.collection.immutable.Seq[Int] = List() //we ate the timeout

scala> val remotePorts = openPorts(fromPort = 12000, toPort = 13000, address="91.190.218.61", duration=30 seconds)
remotePorts: scala.collection.immutable.Seq[Int] = Vector(12345, 12350)