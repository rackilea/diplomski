static byte [] GetFileBytes (String filename) 
    throws java.io.FileNotFoundException,
           java.io.IOException {
    java.io.File f= new java.io.File (filename);
    java.io.FileInputStream fi= new java.io.FileInputStream (f);
    long fsize = f.length ();
    byte b [] = new byte [(int)fsize];
    int rsize= fi.read (b, 0, (int)fsize);
    fi.close ();
    if (rsize!=fsize) {
        byte [] btmp= new byte [rsize];
        System.arraycopy (b, 0, btmp, 0, rsize);
        b= btmp;
    }
    return b;
}