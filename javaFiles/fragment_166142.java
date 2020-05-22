w = new DataOutputStream(new BufferedOutputStream(receivedSocketConn1.getOutputStream()));
r = new DataInputStream(new BufferedInputStream(receivedSocketConn1.getInputStream()));

try
{
    while(true)
    {
        if (r.readByte() != 0x7E) // start byte
            throw new RuntimeException("Incorrect start byte detected");

        int messageID = r.readUnsignedShort();     // message ID
        int bodyLen = r.readUnsignedShort();       // message body nature (body length)
        byte[] phoneNum = new byte[6];
        r.readFully(phoneNum);                     // device phone number
        int serialNum = r.readUnsignedShort();     // message serial number
        byte[] messageBody = new byte[bodyLen];    // message body
        r.readFully(messageBody);
        byte checkCode = r.readByte();             // check code

        if (r.readByte() != 0x7E) // end byte
            throw new RuntimeException("Incorrect end byte detected");

        // TODO: validate checkCode if needed...
        // ... 
        // if (checkCode is not valid)
        //    throw new RuntimeException("Bad checkCode value");

        // process message data as needed...
    }
}
catch (SocketTimeoutException ex)  
{ 
    System.out.println("SocketTimeoutException has been caught");
    ex.printStackTrace();
}  
catch (EOFException ex)  
{ 
    System.out.println("Socket has been closed");
}  
catch (IOException ex)  
{ 
    System.out.println("IOException has been caught");
    ex.printStackTrace();
} 
catch (RuntimeException ex)
{ 
    System.out.println(ex.getMessage());
    ex.printStackTrace();
} 
finally
{
    w.close();
    r.close();
    receivedSocketConn1.close();
}