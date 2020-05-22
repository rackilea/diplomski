import org.apache.xmlbeans.*;

public class main {
    public static void main ( String[] args ) throws XmlException {
        XmlObject x = XmlObject.Factory.parse( "<BankRate>        </BankRate>" );
        XmlCursor c = x.newCursor();
        c.toFirstContentToken();
        c.toNextToken();
        c.setBookmark(CDataBookmark.CDATA_BOOKMARK);
        XmlOptions options = new XmlOptions();
        options.setSaveCDataLengthThreshold( 1 );
        options.setUseCDataBookmarks();
        System.out.print( x.xmlText( options ) );
    }
}