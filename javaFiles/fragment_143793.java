try (
    ZipOutputStream zos = new ZipOutputStream(...);
    OutputStreamWriter writer = new OutputStreamWriter( zos )
){
    ...
    zos.putNextEntry( new ZipEntry( "fileName.txt" ) );
    String content = "some text content here";
    writer.write( content );
    writer.flush();
    ...
}