BufferedReader in;
String readLine;
try
{
    in = new BufferedReader(new InputStreamReader(url.openStream(), "ISO-8859-1"));
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter( new FileOutputStream(file) , "UTF-8"));

    while ((readLine = in.readLine()) != null)
        out.write(readLine+"\n");
    out.flush();
    out.close();
}

catch (UnsupportedEncodingException e)
{
    e.printStackTrace();
}

catch (IOException e)
{
    e.printStackTrace();
}