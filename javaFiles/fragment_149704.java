package net.femtoparsec.jssc;

import jssc.SerialPort;
import jssc.SerialPortException;

import java.io.IOException;

public class JsscByteWriter implements ByteWriter {

    private final SerialPort serialPort;

    public JsscByteWriter(SerialPort serialPort) {
        this.serialPort = serialPort;
    }

    @Override
    public void cancelWrite() throws IOException {
        try {
            serialPort.purgePort(SerialPort.PURGE_TXABORT);
            serialPort.purgePort(SerialPort.PURGE_TXCLEAR);
        } catch (SerialPortException e) {
            throw new IOException(e);
        }
    }

    @Override
    public void write(byte[] bytes) throws IOException {
        try {
            serialPort.writeBytes(bytes);
        } catch (SerialPortException e) {
            throw new IOException(e);
        }
    }

    @Override
    public void write(byte oneByte) throws IOException {
        try {
            serialPort.writeByte(oneByte);
        } catch (SerialPortException e) {
            throw new IOException(e);
        }
    }

    @Override
    public void write(byte[] bytes, long timeout) throws IOException, InterruptedException {
        if (timeout <= 0) {
            this.write(bytes);
        }
        else {
            new TimedOutByteWriting(this, bytes, timeout).write();
        }
    }

    @Override
    public void write(byte oneByte, long timeout) throws IOException, InterruptedException {
        if (timeout <= 0) {
            this.write(oneByte);
        }
        else {
            new TimedOutByteWriting(this, oneByte, timeout).write();
        }
    }


}