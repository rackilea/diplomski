File cachePath = new File(context.getCacheDir(), "SubDir");
String filename = "test.jpeg";
boolean errs = false;

if( !cachePath.exists() ) {
    // mkdir would work here too if your path is 1-deep or
    // you know all the parent directories will always exist
    errs = !cachePath.mkdirs();
}

if(!errs) {
    FileOutputStream fout = new FileOutputStream(cachePath + "/" + filename);
    fout.write(bytes.toByteArray());
    fout.flush();
    fout.close();
}