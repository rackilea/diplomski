import java.nio.ByteBuffer
import java.nio.channels.FileChannel
import java.nio.charset.StandardCharsets
import java.nio.file.{Path, Paths, StandardOpenOption}

import scala.util.{Failure, Success, Try}

object ExclusiveFsWrite {
  def main(args: Array[String]): Unit = {
    val path = Paths.get("/tmp/file")
    val buffer = ByteBuffer.wrap("Some text data here".getBytes(StandardCharsets.UTF_8))

    val fc = getExclusiveFileChannel(path)
    try {
      fc.write(buffer)
    }
    finally {
      // channel close will also release a lock
      fc.close()
    }

    ()
  }

  private def getExclusiveFileChannel(path: Path): FileChannel = {
    // Append if exist or create new file (if does not exist)
    val fc = FileChannel.open(path, StandardOpenOption.WRITE, StandardOpenOption.APPEND,
      StandardOpenOption.CREATE)
    if (fc.size > 0) {
      // set position to the end
      fc.position(fc.size - 1)
    }
    // get an exclusive lock
    Try(fc.lock()) match {
      case Success(lock) =>
        println("Is shared lock: " + lock.isShared)
        fc
      case Failure(ex) =>
        Try(fc.close())
        throw ex
    }
  }
}