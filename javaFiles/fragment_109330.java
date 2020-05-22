import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

...

byte[] audioBytes = ...

ShortBuffer sbuf =
    ByteBuffer.wrap(audioBytes).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer();
short[] audioShorts = new short[sbuf.capacity()];
sbuf.get(audioShorts);