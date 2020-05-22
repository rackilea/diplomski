java.nio.Files.write(new Path(...),
                     myOutputString,  // or StringBuffer/StringBuilder/Charbuffer
                     myCharset,       // e.g. java.nio.charset.Charset.forName("UTF8")
                     java.nio.file.StandardOpenOption.WRITE);


BufferedWriter bw =  java.nio.files.Files.newBufferedWriter(
                                               new Path(...),
                                               myCharset,
                                               java.nio.file.StandardOpenOption.WRITE);
for (...) {
      bw.write(...);
}
bw.flush();
bw.close();