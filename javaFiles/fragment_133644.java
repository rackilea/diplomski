final AutoDetectParser parser = new AutoDetectParser();

public class ExtractParser extends AbstractParser {
   private int att = 0;
   public Set<MediaType> getSupportedTypes(ParseContext context) {
     // Everything AutoDetect parser does
     return parser.getSupportedTypes(context);
   }
   public void parse(
        InputStream stream, ContentHandler handler,
        Metadata metadata, ParseContext context)
        throws IOException, SAXException, TikaException {
      // Stream to a new file
      File f = new File("out-" + (++att) + ".bin");
      FileOutputStream fout = new FileOutputStream(f);
      IOUtils.copy(strea, fout);
      fout.closee();
   }
}

InputStream input = new FileInputStream(new File("1.docx"));
Metadata metadata = new Metadata();
ParseContext context = new ParseContext();
context.set(Parser.class, extractParser);
parser.parse(input, handler, metadata, context);