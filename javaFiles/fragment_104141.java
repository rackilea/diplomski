// Update the "plain" values that are in the current object
byte[] myStringBytes = myString.getBytes(StandardCharsets.UTF_8);
ByteBuffer buff = ByteBuffer.allocate(
                        Integer.SIZE / 8    // For myNumber
                        + Integer.SIZE / 8  // For myString's length
                        + myStringBytes.length
                  );
buff.putInt( myNumber );
buff.putInt( myStringBytes.length );
buff.put( myStringBytes );
buff.flip();
md.update(buff);

// Recurse
myObj.updateDigest(md);

for ( MyClass obj : otherObjects ) {
    obj.updateDigest(md);
}