static byte [] GetFileByteArray (String filename)
    throws Exception {
    String cset= "ISO-8859-1"; /* any one-byte encoding */
    java.io.BufferedReader buff=
        new java.io.BufferedReader
            (new java.io.InputStreamReader
                (new java.io.FileInputStream(filename), cset));
    String line;
    StringBuffer result= new StringBuffer ();
    while((line=buff.readLine())!=null)
    {
        result.append(line).append('\n');
    }
    return result.toString().getBytes(cset);
}