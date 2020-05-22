@Override
public void serialEvent(SerialPortEvent serialPortEvent) {
    byte[] newData = new byte[comPort.bytesAvailable()];
    int numRead = comPort.readBytes(newData, newData.length);
    handleData(new String(newData));
}