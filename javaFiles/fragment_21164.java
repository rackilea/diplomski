public void createBundle() {
    ZipOutputStream out = .... 
    writeHeader( out );
    writeLimits( out yourFiles );
    for( File f : youFiles ) {
        writeFileTo( f, out );
     }
     out.close();
}