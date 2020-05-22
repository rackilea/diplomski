StringBuilder msg = new StringBuilder();
   for (;;) {
    int numBytesRead = client.read(buf);
    if (numBytesRead==-1)
        break;
    if (numBytesRead>0) {
        buf.flip();
        byte[] tempb = new byte[buf.remaining()];
        buf.get(tempb); 
        String s = new String(tempb);
        msg.append(s);
    }
   }
   client.close();
   System.out.prinltn(msg);