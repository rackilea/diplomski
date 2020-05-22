public class XMLReader {
    public String[] read (String xmlFile) throws XmlPullParserException, IOException {
        String[] stationData = new String[]{"",""};
        //code to cut xml file up and put it into stationData
        return stationData;
    }
}

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            XMLReader r = new XMLReader();
            String[] stationData = r.read(getXML());
            newStation(Integer.parseInt(stationData[0]), stationData[1]);
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void newStation(int stationID, String stationName) { ... }
    private String getXML() { ... }
}