package stack43366566;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import stack43366566.gen.XMLLexer;
import stack43366566.gen.XMLParser;
import stack43366566.gen.XMLParser.DocumentContext;
import stack43366566.gen.XMLParserBaseListener;

public class FindXmlOffset {

    List<Integer> offsets = null;
    String searchForElement = null;

    public class MyXMLListener extends XMLParserBaseListener {
        public void enterElement(XMLParser.ElementContext ctx) {
            String name = ctx.Name().get(0).getText();
            if (searchForElement.equals(name)) {
                offsets.add(ctx.start.getStartIndex());
            }
        }
    }

    public List<Integer> createOffsets(String file, String elementName) {
        searchForElement = elementName;
        offsets = new ArrayList<>();
        try {
            XMLLexer lexer = new XMLLexer(new ANTLRFileStream(file));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            XMLParser parser = new XMLParser(tokens);
            DocumentContext ctx = parser.document();
            ParseTreeWalker walker = new ParseTreeWalker();
            MyXMLListener listener = new MyXMLListener();
            walker.walk(listener, ctx);
            return offsets;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] arg) {
        System.out.println("Search for offsets.");
        List<Integer> offsets = new FindXmlOffset().createOffsets("/tmp/dewiki-20170501-pages-articles-multistream.xml",
                        "page");
        System.out.println("Offsets: " + offsets);
    }

}