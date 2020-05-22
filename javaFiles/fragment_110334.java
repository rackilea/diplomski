import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author visruth
 */
public class HandlingXmlStuff extends DefaultHandler {

    private String key;
    private Map<String, String> request = new HashMap<String, String>();
    private Map<String, String> current_condition = new HashMap<String, String>();
    private List<Map<String, String>> weather = new ArrayList<Map<String, String>>();
    private Map<String, String> weatherMap;
    private boolean requestStatus;
    private boolean current_conditionStatus;
    private boolean weatherStatus;

    public Map<String, String> getCurrent_condition() {
        return this.current_condition;
    }

    public Map<String, String> getRequest() {        
        return this.request;
    }

    public List<Map<String, String>> getWeather() {        
        return this.weather;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        key = qName;
        if (qName.equals("request")) {

            requestStatus = true;
        } else if (qName.equals("current_condition")) {

            current_conditionStatus = true;
        } else if (qName.equals("weather")) {
            weatherMap = new HashMap<String, String>();
            weatherStatus = true;
        }        

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

        String value = new String(ch, start, length).trim();
        if (requestStatus) {
            if (!key.trim().equals("request") && !key.trim().isEmpty() && !value.isEmpty()) {
                request.put(key, value);
            }            
        } else if (current_conditionStatus) {
            if (!key.trim().equals("current_condition") && !key.trim().isEmpty() && !value.isEmpty()) {
                current_condition.put(key, new String(ch, start, length).trim());
            }
        } else if (weatherStatus) {
            if (!key.trim().equals("weather") && !key.trim().isEmpty() && !value.isEmpty()) {
                weatherMap.put(key, new String(ch, start, length).trim());
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (qName.equals("request")) {
            requestStatus = false;
        } else if (qName.equals("current_condition")) {
            current_conditionStatus = false;
        } else if (qName.equals("weather")) {
            weather.add(weatherMap);
            weatherStatus = false;            
        }
    }

    public void parseDocument() {
        //get a factory
        SAXParserFactory spf = SAXParserFactory.newInstance();
        try {
            //get a new instance of parser
            SAXParser sp = spf.newSAXParser();            
            //parse the file and also register this class for call backs
            sp.parse("http://free.worldweatheronline.com/feed/weather.ashx?q=peshawar,pakistan&format=xml&num_of_days=5&key=eab9f57359164426132301", this);
        } catch (SAXException se) {
            se.printStackTrace();
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }
}