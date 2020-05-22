public static void main(String[] args) 
  {
      byte[] idNum = ByteBuffer.allocate(4).putInt(46152604).array();
      byte version = 0xFF & 88; //only need a byte not a 4 byte int
      byte deviceType = 0xFF & 13; //only need a byte not a 4 byte int

      short manuID = createManuID("ZRI");
      //builds the message without overflow now
      byte[] data = ByteBuffer.allocate(8).put(idNum).putShort(manuID).put(version).put(deviceType).array(); 

  }