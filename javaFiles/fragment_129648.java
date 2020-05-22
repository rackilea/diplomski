import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.stream.*;

/* IMPLEMENT THIS TO YOUR CLASS IN ORDER TO TO BE NOTIFIED WHEN A NODE IS FOUND*/
interface XMLNodeFoundNotifier {

    abstract void nodeFound(StringBuilder node, XMLStackFilter withFilter);
}

/* A SMALL HANDER USEFULL FOR EXPLICIT CLASS DECLARATION */
abstract class XMLHandler implements XMLNodeFoundNotifier {
}

/* INTERFACE TO WRITE YOUR OWN FILTER BASED ON THE CURRENT NODES STACK (PATH)*/
interface XMLStackFilter {

    abstract boolean isRelevant(Stack fullPath);
}

/* A VERY USEFULL FILTER USING REGEX AS THE PATH FILTER */
class XMLRegexFilter implements XMLStackFilter {

    Pattern relevantExpression;

    XMLRegexFilter(String filterRules) {
        relevantExpression = Pattern.compile(filterRules);
    }

    /* HERE WE ARE ARE ASK TO TELL IF THE CURRENT STACK (LIST OF NODES) IS RELEVANT
     * OR NOT ACCORDING TO WHAT WE WANT. RETURN TRUE IF THIS IS THE CASE */
    @Override
    public boolean isRelevant(Stack fullPath) {
        /* A POSSIBLE CLEVER WAY COULD BE TO SERIALIZE THE WHOLE PATH (INCLUDING
         * ATTRIBUTES) TO A STRING AND TO MATCH IT WITH A REGEX BEING THE FILTER
         * FOR NOW StackToString DOES NOT SERIALIZE ATTRIBUTES */
        String stackPath = XMLParser.StackToString(fullPath);
        Matcher m = relevantExpression.matcher(stackPath);
        return  m.matches();
    }
}

/* THE MAIN PARSER'S CLASS */
public class XMLParser {

    HashMap<XMLStackFilter, XMLNodeFoundNotifier> filterHandler;
    HashMap<Integer, Integer> feedingStreams;
    Stack<HashMap> currentStack;
    String filePath;

    XMLParser() {
        currentStack   = new <HashMap>Stack();
        filterHandler  = new <XMLStackFilter, XMLNodeFoundNotifier> HashMap();
        feedingStreams = new <Integer, Integer>HashMap();
    }

    public void addFilterWithHandler(XMLStackFilter f, XMLNodeFoundNotifier h) {
        filterHandler.put(f, h);
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /* CONVERT A STACK OF NODES TO A REGULAR PATH STRING. NOTE THAT PER DEFAULT 
     * I DID NOT ADDED THE ATTRIBUTES INTO THE PATH. UNCOMENT THE LINKS ABOVE TO
     * DO SO
     */
    public static String StackToString(Stack<HashMap> s) {
        int k = s.size();
        if (k == 0) {
            return null;
        }
        StringBuilder out = new StringBuilder();
        out.append(s.get(0).get("tag"));
        for (int x = 1; x < k; ++x) {
            HashMap node = s.get(x);
            out.append('/').append(node.get("tag"));
            /* 
            // UNCOMMENT THIS TO ADD THE ATTRIBUTES SUPPORT TO THE PATH

            ArrayList <String[]>attributes = (ArrayList)node.get("attr");
            if (attributes.size()>0)
            {
            out.append("[");
            for (int i = 0 ; i<attributes.size(); i++)
            {
            String[]keyValuePair = attributes.get(i);
            if (i>0) out.append(",");
            out.append(keyValuePair[0]);
            out.append("=\"");
            out.append(keyValuePair[1]);
            out.append("\"");
            }
            out.append("]");
            }*/
        }
        return out.toString();
    }

    /*
     * ONCE A NODE HAS BEEN SUCCESSFULLY FOUND, WE GET THE DELIMITERS OF THE FILE
     * WE THEN RETRIEVE THE DATA FROM IT.
     */
    private StringBuilder getChunk(int from, int to) throws Exception {
        int length = to - from;
        FileReader f = new FileReader(filePath);
        BufferedReader br = new BufferedReader(f);
        br.skip(from);
        char[] readb = new char[length];
        br.read(readb, 0, length);
        StringBuilder b = new StringBuilder();
        b.append(readb);
        return b;
    }
    /* TRANSFORMS AN XSR NODE TO A HASHMAP NODE'S REPRESENTATION */
    public HashMap XSRNode2HashMap(XMLStreamReader xsr) {
        HashMap h = new HashMap();
        ArrayList attributes = new ArrayList();

        for (int i = 0; i < xsr.getAttributeCount(); i++) {
            String[] s = new String[2];
            s[0] = xsr.getAttributeName(i).toString();
            s[1] = xsr.getAttributeValue(i);
            attributes.add(s);
        }

        h.put("tag", xsr.getName());
        h.put("attr", attributes);

        return h;
    }

    public void parse() throws Exception {
        FileReader f         = new FileReader(filePath);
        XMLInputFactory xif  = XMLInputFactory.newInstance();
        XMLStreamReader xsr  = xif.createXMLStreamReader(f);
        Location previousLoc = xsr.getLocation();

        while (xsr.hasNext()) {
            switch (xsr.next()) {
                case XMLStreamConstants.START_ELEMENT:
                    currentStack.add(XSRNode2HashMap(xsr));
                    for (XMLStackFilter filter : filterHandler.keySet()) {
                        if (filter.isRelevant(currentStack)) {
                            feedingStreams.put(currentStack.hashCode(), new Integer(previousLoc.getCharacterOffset()));
                        }
                    }
                    previousLoc = xsr.getLocation();
                    break;

                case XMLStreamConstants.END_ELEMENT:
                    Integer stream = null;
                    if ((stream = feedingStreams.get(currentStack.hashCode())) != null) {
                        // FIND ALL THE FILTERS RELATED TO THIS FeedingStreem AND CALL THEIR HANDLER.
                        for (XMLStackFilter filter : filterHandler.keySet()) {
                            if (filter.isRelevant(currentStack)) {
                                XMLNodeFoundNotifier h = filterHandler.get(filter);

                                StringBuilder aChunk = getChunk(stream.intValue(), xsr.getLocation().getCharacterOffset());
                                h.nodeFound(aChunk, filter);
                            }
                        }
                        feedingStreams.remove(currentStack.hashCode());
                    }
                    previousLoc = xsr.getLocation();
                    currentStack.pop();
                    break;
                default:
                    break;
            }
        }
    }
}