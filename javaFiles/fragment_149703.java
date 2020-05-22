package net.femtoparsec.jssc;

import java.io.IOException;

public interface ByteWriter {

    void write(byte[] bytes) throws IOException;

    void write(byte oneByte) throws IOException;

    void write(byte[] bytes, long timeout) throws IOException, InterruptedException;

    void write(byte oneByte, long timeout) throws IOException, InterruptedException;

    void cancelWrite() throws IOException;

}