import java.io.*;
import java.net.*;
import javax.swing.text.*;
import javax.swing.text.html.*;

class GetSpan
{
    public static void main(String[] args)
        throws Exception
    {
        // Create a reader on the HTML content

        Reader reader = getReader( args[0] );

        // Parse the HTML

        EditorKit kit = new HTMLEditorKit();
        HTMLDocument doc = (HTMLDocument)kit.createDefaultDocument();
        doc.putProperty("IgnoreCharsetDirective", Boolean.TRUE);
        kit.read(reader, doc, 0);

        // Find all the Span elements in the HTML document

        HTMLDocument.Iterator it = doc.getIterator(HTML.Tag.SPAN);

        while (it.isValid())
        {
            int start = it.getStartOffset();
            int end = it.getEndOffset();
            String text = doc.getText(start, end - start);
            System.out.println(  text );
            it.next();
        }
    }

    // If 'uri' begins with "http:" treat as a URL,
    // otherwise, treat as a local file.
    static Reader getReader(String uri)
        throws IOException
    {
        // Retrieve from Internet.
        if (uri.startsWith("http"))
        {
            URLConnection conn = new URL(uri).openConnection();
            return new InputStreamReader(conn.getInputStream());
        }
        // Retrieve from file.
        else
        {
            return new FileReader(uri);
        }
    }
}