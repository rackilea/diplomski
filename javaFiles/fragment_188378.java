byte[] data = new byte[6556];
try {
   in = socket.getInputStream();
   // NOTE: The data byte array will contain empty values if
   // under the size of 6556
   int size = in.read(data);

   // send to LogCat
   Log.e("String", data.toString());
} catch (Exception e) {
   e.printStackTrace();
}