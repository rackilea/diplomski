import com.sun.xml.internal.bind.marshaller.NamespacePrefixMapper;
//import com.sun.xml.bind.marshaller.NamespacePrefixMapper;

public class MyNamespaceMapper extends NamespacePrefixMapper {

    private static final String FOO_PREFIX = ""; // DEFAULT NAMESPACE
    private static final String FOO_URI = "http://www.example.com/FOO";

    private static final String BAR_PREFIX = "bar";
    private static final String BAR_URI = "http://www.example.com/BAR";

    @Override
    public String getPreferredPrefix(String namespaceUri, String suggestion, boolean requirePrefix) {
        if(FOO_URI.equals(namespaceUri)) {
            return FOO_PREFIX;
        } else if(BAR_URI.equals(namespaceUri)) {
            return BAR_PREFIX;
        }
        return suggestion;
    }

    @Override
    public String[] getPreDeclaredNamespaceUris() {
        return new String[] { FOO_URI, BAR_URI };
    }

}