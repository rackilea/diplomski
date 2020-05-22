List<byte[]> bytesList = ...

Observable.fromIterable(bytesList)
.collect(ByteArrayOutputStream::new, (bout, bytes) -> bout.write(bytes, 0, bytes.length))
.map(bout -> bout.toByteArray())
// work with the byte array
;