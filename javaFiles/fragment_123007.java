//Converts a String that represents an IP to an int.
   InetAddress i= InetAddress.getByName(IPString);
   int intRepresentation= ByteBuffer.wrap(i.getAddress()).getInt();

   //This convert an int representation of ip back to String
   i= InetAddress.getByName(String.valueOf(intRepresentation));
   String ip= i.getHostAddress();