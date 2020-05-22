public static void main(String[] args) throws IOException 
{
    File f = new File("SomeFileName");
    FileInputStream fis = new FileInputStream(f);
    InputStreamReader isr = new InputStreamReader(fis);
    BufferedReader br = new BufferedReader(irs);

    // Use the BufferedReader

    br.close();
    isr.close();
    fis.close();

}