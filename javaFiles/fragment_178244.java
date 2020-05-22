InputStream realOne = ..
// beware of the encoding!
InputStream root = new ByteArrayInputStream("<object-stream>".toBytes("UTF-8")); 
InputStream all = new SequenceInputStream(root, realOne);

xstream.createObjectInputStream(withRoot); // voi lá