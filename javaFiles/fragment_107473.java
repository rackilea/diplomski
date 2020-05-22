class KryoSO {
    import com.esotericsoftware.kryo.KryoSerializable
    import de.javakaffee.kryoserializers.KryoReflectionFactorySupport
    import com.esotericsoftware.kryo.Kryo
    import com.esotericsoftware.kryo.Serializer
    import java.io.{ InputStream, OutputStream }
    import com.esotericsoftware.kryo.io.{ Output, Input }
    import java.sql.Timestamp

    object TimestampSerializer extends Serializer[Timestamp] {
      override def write(kryo: Kryo, output: Output, t: Timestamp): Unit = {
        output.writeLong(t.getTime(), true);
      }

      override def read(kryo: Kryo, input: Input, t: Class[Timestamp]): Timestamp = {
        new Timestamp(input.readLong(true));
      }

      override def copy(kryo: Kryo, original: Timestamp): Timestamp = {
        new Timestamp(original.getTime());
      }
    }
    val kryo: Kryo = new KryoReflectionFactorySupport
    kryo.addDefaultSerializer(classOf[Timestamp], TimestampSerializer)

    def serialize(o: Any, os: OutputStream) = {
      val output = new Output(os);
      this.kryo.writeClassAndObject(output, o);
      output.flush();
    }

    def deserialize(is: InputStream): Any = {
      kryo.readClassAndObject(new Input(is));
    }

  }
  val k = new KryoSO
  val b = new java.io.ByteArrayOutputStream
  val timestamp = new java.sql.Timestamp(System.currentTimeMillis())

  k.serialize(timestamp, b)

  val result = k.deserialize(new java.io.ByteArrayInputStream(b.toByteArray()))

  println(timestamp)
  println(result.getClass)
  println(result.isInstanceOf[java.sql.Timestamp])
  println(timestamp == result)