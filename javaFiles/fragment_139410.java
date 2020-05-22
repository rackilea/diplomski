ByteBuffer lastBuffer = null;
Future<Integer> future = null;

public void execute(){
    try {
        if(_packet == null){
            AppLogger.warn("Tcp job packet is null");
            return;
        }
        // need to wait until the last buffer was written completely.
        while (future != null) {
           future.get();
           if (lastBuffer.remaining() > 0)
              future = _writer.write(lasBuffer);
           else
              break;
        }
        // start another write.
        future = _writer.write(lastBuffer = _packet.toByteArray());
    } catch (IOException e) {
        AppLogger.error("Failed to write packet into the stream.", e);
    }
}