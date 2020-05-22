// realOutputStream should probably be a BufferedOutputStream
DataOutputStream output = new DataOutputStream( realOutputStream );
for (Map.Entry<Long, String> entry : map.entrySet()) {
    // Write the key
    output.writeLong(entry.getKey().longValue());
    byte bytes[] = entry.getBytes("UTF-8");
    // Writing the string requires writing the length and then the bytes
    output.writeInt(bytes.length);
    output.write(bytes, 0, bytes.length);
}



// realInputStream should probably be a BufferedInputStream
DataInputStream input = new DataInputStream ( realInputStream );
Map<Long, String> map = new HashMap<Long, String>();
while ( true ) {
   try {
     // read the key
     long key = output.readLong();
     // read the string length in bytes
     int strlen = output.readInt();
     // read the bytes into an array
     byte buf[] = new byte[strlen];
     output.readFully(buf, 0, strlen);
     // Create the map entry.
     map.put(Long.valueOf(key), new String(buf,"UTF-8"));
   }
   catch (EOFException e) {
     // input is exhausted
     break;
   }
}