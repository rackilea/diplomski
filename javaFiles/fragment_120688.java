import java.io.*;
import java.net.*;
import javax.swing.text.*;
import javax.swing.text.html.parser.*;
import javax.swing.text.html.*;

public class ParserCallbackText extends HTMLEditorKit.ParserCallback
{
    private boolean isBody = false;

    public void handleText(char[] data, int pos)
    {
        if (isBody)
            System.out.println( data );
    }

    public void handleStartTag(HTML.Tag tag, MutableAttributeSet a, int pos)
    {
        if (tag.equals(HTML.Tag.BODY))
        {
            isBody = true;
        }
    }

    public static void main(String[] args)
        throws Exception
    {
        Reader reader = getReader(args[0]);
        ParserCallbackText parser = new ParserCallbackText();
        new ParserDelegator().parse(reader, parser, true);
    }

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