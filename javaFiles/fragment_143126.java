private static boolean isSixBytesSequence(byte b)
{
    return -4 <= b && b <= -3;
}
public static Charset getDefaultSystemCharset()
{
    return Charset.forName(System.getProperty("file.encoding"));
}
private static boolean hasUTF8Bom(byte[] bom)
{
    return (bom[0] == -17 && bom[1] == -69 && bom[2] == -65);
}
private static boolean hasUTF16LEBom(byte[] bom)
{
return (bom[0] == -1 && bom[1] == -2);
}
private static boolean hasUTF16BEBom(byte[] bom)
{
    return (bom[0] == -2 && bom[1] == -1);
}
public static Charset[] getAvailableCharsets()
{
    Collection collection = Charset.availableCharsets().values();
    return (Charset[]) collection.toArray(new Charset[collection.size()]);
}
public static void main(String[] args) throws FileNotFoundException, IOException
{
File file = new File("windows-1252.txt");
    Charset guessedCharset = CharsetToolkit.guessEncoding(file, 4096);
    System.err.println("Charset found: " + guessedCharset.displayName());
FileInputStream fis = new FileInputStream(file);
    InputStreamReader isr = new InputStreamReader(fis, guessedCharset);
    BufferedReader br = new BufferedReader(isr);
    String line;
    while ((line = br.readLine()) != null)
    {
        System.out.println(line);

    }}}