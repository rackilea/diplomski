import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream
import org.apache.spark.input.PortableDataStream
import scala.util.Try
import java.nio.charset._

def extractFiles(ps: PortableDataStream, n: Int = 1024) = Try {
  val tar = new TarArchiveInputStream(new GzipCompressorInputStream(ps.open))
  Stream.continually(Option(tar.getNextTarEntry))
    // Read until next exntry is null
    .takeWhile(_.isDefined)
    // flatten
    .flatMap(x => x)
    // Drop directories
    .filter(!_.isDirectory)
    .map(e => {
      Stream.continually {
        // Read n bytes
        val buffer = Array.fill[Byte](n)(-1)
        val i = tar.read(buffer, 0, n)
        (i, buffer.take(i))}
      // Take as long as we've read something
      .takeWhile(_._1 > 0)
      .map(_._2)
      .flatten
      .toArray})
    .toArray
}

def decode(charset: Charset = StandardCharsets.UTF_8)(bytes: Array[Byte]) = 
  new String(bytes, StandardCharsets.UTF_8)

sc.binaryFiles("somePath").flatMapValues(x => 
  extractFiles(x).toOption).mapValues(_.map(decode()))