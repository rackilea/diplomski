import java.io.{FileInputStream, RandomAccessFile}
import java.nio.ByteBuffer

import org.bytedeco.javacpp.avformat._
import org.bytedeco.javacpp.avutil.AVDictionary
import org.bytedeco.javacpp._
import org.bytedeco.javacpp.annotation.Cast
import org.bytedeco.javacpp.avcodec.{AVCodecContext, AVPacket}

/**
 * User: peter
 * Date: 2/17/17
 * Time: 7:47 PM
 */
object FFMEGTest2 extends App {
val AVERROR_NONE = 0
val AVERROR_EAGAIN = -11
val AVERROR_RESOURCE_NOT_AVAILABLE = -35

def chk( x: Int ) = {
if( x < 0 ) {
  val errormsgBytes = new Array[Byte](1024)
  avutil.av_strerror(x, errormsgBytes, 1024)
  throw new Error(new String(errormsgBytes).trim)
}
x
}

def chkNull[T]( x: T ) = {
if(x==null) {
  throw new Error("Unable to allocate object")
}
x
}

avformat.av_register_all()

val mp4 = "foo.mp4"
val ogg = "bah.ogg"

doit(mp4, "mp4") 
doit(ogg, "ogg")

def doit( path: String, fmt: String ): Unit = {
val input = new RandomAccessFile(path,"r")
val data = new Array[Byte](input.length().toInt)
input.read(data, 0, data.length)
doit(data,fmt)
}

def doit( data: Array[Byte], fmt: String ) = {

val pointerPointer = new PointerPointer(1)
val lineSizePtr = new IntPointer(1L)
chk(avutil.av_samples_alloc(pointerPointer,lineSizePtr,1,4096,8,0))

var offset = 0

object ReadInput extends Read_packet_Pointer_BytePointer_int {
  override def call(opaque: Pointer, buffer: BytePointer, buffer_size: Int): Int = {
    try {
      println(s"read ${offset} ${buffer_size}")
      if (offset >= data.length) {
        avutil.AVERROR_EOF
      }
      else {
        val avail = data.length - offset
        val l = if( avail < buffer_size ) avail else buffer_size
        //Array.copy(data,offset,buffer,0,avail)
        buffer.put(data, offset, l)
        offset += l
        l
      }
    }
    catch {
      case t: Throwable =>
        throw new Error("Error on InputStream.read(): ", t)
    }
  }
}

object SeekInput extends Seek_Pointer_long_int {
  @Cast(Array("int64_t")) override def call(userDataPtr: Pointer, @Cast(Array("int64_t")) where: Long, whence: Int): Long = {
    /*
#define SEEK_SET                0       // Seek relative to begining of file
#define SEEK_CUR                1       // Seek relative to current file position
#define SEEK_END                2       // Seek relative to end of file

    avformat.AVSEEK_SIZE

    ORing this as the "whence" parameter to a seek function causes it to
    return the filesize without seeking anywhere. Supporting this is optional.
    If it is not supported then the seek function will return <0.
     */
    try {
      val whence2 = whence & ~avformat.AVSEEK_SIZE

      whence2 match {
        case 0 => offset = where.toInt
        case 1 => offset = offset + where.toInt
        case 2 => offset = data.length - where.toInt
        case _ =>
          throw new Error(s"Unknown whence on InputStream.seek(): ${where} ${whence2} ")
      }
      if( (whence & avformat.AVSEEK_SIZE) != 0) data.length else 0
    } catch {
      case t: Throwable =>
        throw new Error("Error on InputStream.reset() or skip(): ", t)
    }
  }
}

val avioBufferSize = 4096
val avioBuffer = new BytePointer(avutil.av_malloc(avioBufferSize))
val formatContext = chkNull(avformat.avformat_alloc_context())
val avioContext = chkNull(avformat.avio_alloc_context(
  avioBuffer,
  avioBufferSize,
  0,
  formatContext,
  ReadInput,
  null,
  SeekInput))

formatContext.pb(avioContext)

val inputFormat = chkNull(avformat.av_find_input_format(fmt))
formatContext.iformat(inputFormat)
chk(avformat.avformat_open_input(formatContext, "", null, null))

val audioStreams = (0 until formatContext.nb_streams) filter { i: Int =>
  formatContext.streams(i).codec().codec_type() == avutil.AVMEDIA_TYPE_AUDIO
}

audioStreams.foreach { audioStream =>

  val codecContext = formatContext.streams(audioStream).codec()

  val decoder = chkNull(avcodec.avcodec_find_decoder(codecContext.codec_id))

  chk(avcodec.avcodec_open2(codecContext, decoder, null.asInstanceOf[AVDictionary]))

  val fifo = chkNull(avutil.av_audio_fifo_alloc(
    8,
    1,
    1024*1024))

  var more = true

  while (more) {
    val packet = new AVPacket
    avcodec.av_init_packet(packet)

    if (avformat.av_read_frame(formatContext, packet) == 0) {

      chk(avcodec.avcodec_send_packet(codecContext, packet))

      val frame = avutil.av_frame_alloc()
      val errno = avcodec.avcodec_receive_frame(codecContext, frame)

      errno match {
        case avutil.AVERROR_EOF => more = false

        // try again, read another packet
        case AVERROR_EAGAIN =>
        case AVERROR_RESOURCE_NOT_AVAILABLE =>

        case AVERROR_NONE =>

          chk(avutil.av_audio_fifo_write(fifo,frame.buf,frame.nb_samples))

          println(s"${avutil.av_audio_fifo_size(fifo)} ${frame.nb_samples} ${frame.format} ${frame.best_effort_timestamp} ${frame.channels} ${frame.decode_error_flags} ${frame.flags} ${frame.sample_rate}")

          if(avutil.av_audio_fifo_size(fifo) >= 4096) {

            chk(avutil.av_audio_fifo_read(fifo,pointerPointer,4096))

            val byteBuf = ByteBuffer wrap(new Array[Byte](4096*4))
            chk(avutil.av_samples_copy(byteBuf,pointerPointer.get(0).asByteBuffer(),0,0,4096,1,8))

            val samples = ByteBuffer.wrap(byteBuf.array()).asFloatBuffer()
          }

        case code: Int =>
          chk(code)
      }

      avutil.av_frame_free(frame)

    } else more = false

    avcodec.av_packet_unref(packet)
  }

  avutil.av_audio_fifo_free(fifo)

  avcodec.avcodec_close(codecContext)
}

avformat.avformat_close_input(formatContext)
}
}