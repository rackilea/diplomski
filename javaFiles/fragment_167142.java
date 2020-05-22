interface ContentHandler {
     public void parse();
     public void map();
}


public class XMLContentHandler implements ContentHandler {

    public void parse() { }

    public void map() { }
}


public class JSONContentHandler implements ContentHandler {

    public void parse() { }

    public void map() { }
}

class ContentFactory {
    public static ContentHandler getInstance(FILE_TYPE fileType) {
        switch(fileType) {
        case XML:
            return new XMLContentHandler();
        case JSON:
            return new JSONContentHandler();
        }
        return null;
    }
}