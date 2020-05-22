writeBuffer.put(inputLine.getBytes()); 
writeBuffer.flip();                       // <--here
client.write(writeBuffer);
...
writeBuffer.clear();                      // <-- should be clear() instead of flip()
Thread.sleep(300);