package org.apache.tika.example;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MimeTypeException;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

public class ParsingExample {

  public static boolean contains(File file, String s) throws MalformedURLException, 
                     IOException, MimeTypeException, SAXException, TikaException
  {
    InputStream         stream    = new FileInputStream(file);
    AutoDetectParser    parser    = new AutoDetectParser();
    BodyContentHandler  handler   = new BodyContentHandler(-1);
    Metadata            metadata  = new Metadata();
    try{
      parser.parse(stream, handler, metadata);
      return handler.toString().toLowerCase().contains(s.toLowerCase());
    }
    catch (IOException | SAXException | TikaException e){
      System.out.println(file + ": " + e + "\n");
      return false;
    }
  }
  public static void main(String[] args)
  {
      try {
        System.out.println("File " + filename + " contains <" + searchString + "> : " 
          + contains(new File(filename), searchString));
      } catch (IOException | SAXException | TikaException ex){
        System.out.println("Error: " + ex);
      }
  }   

  static String parseExample = ":(";
  static String searchString = "slom";
  static String filename = "C:\\Users\\Dov\\x.pdf"; 
}
    /**
     * Example of how to use Tika to parse a file when you do not know its file type
     * ahead of time.
     *
     * AutoDetectParser attempts to discover the file's type automatically, then call
     * the exact Parser built for that file type.
     *
     * The stream to be parsed by the Parser. In this case, we get a file from the
     * resources folder of this project.
     *
     * Handlers are used to get the exact information you want out of the host of
     * information gathered by Parsers. The body content handler, intuitively, extracts
     * everything that would go between HTML body tags.
     *
     * The Metadata object will be filled by the Parser with Metadata discovered about
     * the file being parsed.
     *
     * Note: This example will extract content from the outer document and all
     * embedded documents.  However, if you choose to use a {@link ParseContext},
     * make sure to set a {@link Parser} or else embedded content will not be
     * parsed.
     *
     * @return The content of a file.
   * I let Netbeans add next 3 lines: 
   * @throws java.io.IOException
   * @throws org.xml.sax.SAXException
   * @throws org.apache.tika.exception.TikaException
     */