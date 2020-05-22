public static void main(String[] args) throws IOException 
{
    File f = new File("SomeFileName");
    FileInputStream fis = new FileInputStream(f);
    BufferedReader br = new BufferedReader(new InputStreamReader(fis));
    br.close();

    // throw IOException
    int i = fis.read();
}