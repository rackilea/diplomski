import org.apache.xmlbeans.*;

public class linenumber
{
    public static void main(String[] args) throws XmlException
    {
        XmlOptions options = new XmlOptions().setLoadLineNumbers();
        XmlObject xobj = XmlObject.Factory.parse("<a>\n<b>test</b>\n<c>test</c>\n</a>", options);

        // let's get the line number for the '<c>' xml object
        XmlObject cobj = xobj.selectPath(".//c")[0];
        System.out.println(cobj.xmlText());

        XmlCursor c = null;
        try
        {
            c = cobj.newCursor();

            // search for XmlLineNumber bookmark
            XmlLineNumber ln =
                (XmlLineNumber) c.getBookmark( XmlLineNumber.class );

            if (ln == null)
                ln = (XmlLineNumber) c.toPrevBookmark( XmlLineNumber.class );

            if (ln != null)
            {
                int line = ln.getLine();
                int column = ln.getColumn();
                int offset = ln.getOffset();

                System.out.println("line=" + line + ", col=" + column + ", offset=" + offset);
            }
        }
        finally
        {
            if (c != null) c.dispose();
        }
    }
}