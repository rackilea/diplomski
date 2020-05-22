byte[] outputBuf = new byte[4096]; // Change 4096 to the correct size
ICTFClient.INSTANCE.iniciaClientCTF(outputBuf, /* ... */);

// If the output is not ASCII, e.g. encoded in an encoding which supports Portugese characters, 
// pass the correct CharSet instead
String output = new String(outputBuf, StandarsCharsets.US_ASCII);
System.out.println("Output: " + output);