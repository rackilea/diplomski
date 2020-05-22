byte[] data = messageToSend.getBytes("UTF-8"); // Specify encoding!

// "For all data, stepping by 16 bytes at a time.."
for (int i = 0; i < data.length; i += 16) {
   // How many bytes actually remain (or 16 if more than 16 remain)
   var frameSize = Math.min(16, data.length - i);

   // Construct frame data from data in i..i+frameSize and send.
   // If you want to ALWAYS send 16 bytes, update as appropriate.
   byte[] frameData = new byte[frameSize];
   System.arraycopy(data, i, frameData, 0, frameSize);

   sendFrame(frameData, frameSize);
}