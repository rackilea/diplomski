public class ParserChain {
    private ArrayList<UrlParser> chain = new ArrayList<UrlParser>();
    private int index = 0;
    public void add(UrlParser parser) {
        chain.add(parser);
    }
    public String[] parse(Document doc) throws IOException {
        if (index = chain.size()){
            return null;
        }
        return chain.get(index++).parse(doc);
    }
}

public interface UrlParser {
    public String[] parse(Document doc, ParserChain chain) throws IOException;
}

public abstract class AbstractUrlParser implements UrlParser {
    @Override
    public String[] parse(Document doc, ParserChain chain) throws IOException {
        try {
            return this.doParse(doc);
        } catch (ParseException pe) {
            return chain.parse(doc);
        }
    }
    protected abstract String[]  doParse(Document doc) throws ParseException, IOException;
}