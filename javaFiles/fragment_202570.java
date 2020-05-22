public class ShowAllCOSStrings
{
    static Set<COSString> strings = new HashSet<COSString>();

    static void crawl(COSBase base)
    {
        if (base instanceof COSString)
        {
            strings.add((COSString)base);
            return;
        }
        if (base instanceof COSDictionary)
        {
            COSDictionary dict = (COSDictionary) base;
            for (COSName key : dict.keySet())
            {
                crawl(dict.getDictionaryObject(key));
            }
            return;
        }
        if (base instanceof COSArray)
        {
            COSArray ar = (COSArray) base;

            for (COSBase item : ar)
            {
                crawl(item);
            }
            return;
        }
        if (base instanceof COSNull || 
                base instanceof COSObject || 
                base instanceof COSName || 
                base instanceof COSNumber || 
                base instanceof COSBoolean || 
                base == null)
        {
            return;
        }
        System.out.println("huh? " + base);
    }

    public static void main(String[] args) throws IOException
    {
        PDDocument doc = PDDocument.load(new File("XXX","YYY.pdf"));

        for (COSObject obj : doc.getDocument().getObjects())
        {
            COSBase base = obj.getObject();
            //System.out.println(obj + ": " + base);
            crawl(base);
        }
        System.out.println(strings.size() + " strings:");
        for (COSString s : strings)
        {
            String str = s.getString();
            if (!str.contains("\n"))
            {
                // avoid display problems with netbeans
                str = str.replaceAll("\r", "\n").replaceAll("\n\n", "\n");
            }
            System.out.println(str);
        }
        doc.close();
    }
}