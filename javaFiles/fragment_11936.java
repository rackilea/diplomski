public interface DocumentParser<K,V> { 

    Map<K,V> parse(Document document);
}


public class ExcelParser implements DocumentParser<String, String> {

    @Override
    public Map<String, String> parse(Document document) {
        // TODO Auto-generated method stub
        return new HashMap<String, String>();
    }

}

public SomeOtherParser implements DocumentParser<String, Integer> {

    @Override
    public Map<String, Integer> parse(Document document) {
        // TODO Auto-generated method stub
        return new HashMap<String, Integer>();
    }
}