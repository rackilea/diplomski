public PrintWriter(File file, String csn)
throws FileNotFoundException, UnsupportedEncodingException
{
this(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), csn)),
     false);
}