package niolock

import java.nio.channels._
import java.nio.file._
import FileChannel.MapMode.{ READ_ONLY => RO }

import scala.util._

object Test extends App {
  val p = FileSystems.getDefault getPath "D:/tmp/mapped"
  val c = FileChannel open p
  var b = c map (RO, 0L, 100L)
  c.close

  Console println Try(Files delete p)
  b = null
  System.gc()
  Console println Try(Files delete p)
}