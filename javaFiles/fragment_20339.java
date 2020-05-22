ByteBuffer src;
//..
//data added to src here
//..
File theFile = new File("hello.gz");
try (FileOutputStream fos = new FileOutputStream(theFile);
     CountingOutputStream cos = new CountingOutputStream(fos);
     GZIPOutputStream zs = new GZIPOutputStream(cos);
     BufferedWriter zipwriter = new BufferedWriter(new OutputStreamWriter(zs, "UTF-8"))) {

    (while_more_data) {
        zipwriter.write(src.get());
        zipwriter.flush(); // make sure, data passes cos
        if (cos.getByteCount() >= limit) {
            // limit reached
        }
    }
}