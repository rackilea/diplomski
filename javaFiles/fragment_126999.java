public void serialEvent(SerialPortEvent event)
{

 if (event.getEventType() == SerialPortEvent.DATA_AVAILABLE)
 {
  System.out.println("Data available event received");

  try
  {
    int available = inputStream.available();
    byte[] readBuffer = new byte[available];

    if (available > 0)
    {
      inputStream.read(readBuffer);
    }

    messageBuffer = messageBuffer + new String(readBuffer);

    try
    {
      int start = messageBuffer.indexOf(new Character((char) 2));
      int end = messageBuffer.indexOf(new Character((char) 10));

      if (start >= 0 && end >= 0)
      {
        System.out.println("We found 1 complete message!!");
        System.out.println(messageBuffer.substring(start, end));
        _fireBufferEvent();
        messageBuffer = "";
      }
    }
    catch (IndexOutOfBoundsException ex)
    {
      System.out.println("IndexOutOfBoundsException, message not complete yet. Waiting for more data.");
    }
  }
  catch (IOException ex)
  {
    System.out.println("IOException while reading data:");
    System.out.println(ex);
  }
}