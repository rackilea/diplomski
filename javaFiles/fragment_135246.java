ByteBuffer[] bbs = list.toArray(new ByteBuffer[0]);
for (ByteBuffer bb : bbs)
    bb.flip(); // assuming this hasn't already been done
long count = channel.write(bbs);
for (ByteBuffer bb : bbs)
    bb.compact();