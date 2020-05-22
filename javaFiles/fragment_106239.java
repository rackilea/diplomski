public class XMLParsingDOMExample extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /** Create a new layout to display the view */
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(1);

        /** Create a new textview array to display the results */
        TextView id[];
        TextView imageurl[];

        try {

            URL url = new URL("http://sagt.vizushop.com/DefaultSimple.aspx?command=default");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new InputSource(url.openStream()));
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("item");

            /** Assign textview array lenght by arraylist size */
            id = new TextView[nodeList.getLength()];
            imageurl = new TextView[nodeList.getLength()];

            for (int i = 0; i < nodeList.getLength(); i++) {

                Node node = nodeList.item(i);

                id[i] = new TextView(this);
                imageurl[i] = new TextView(this);

                Element fstElmnt = (Element) node;
                NodeList idList = fstElmnt.getElementsByTagName("item_id");
                Element idElement = (Element) idList.item(0);
                idList = idElement.getChildNodes();
                id[i].setText("id is = " + ((Node) idList.item(0)).getNodeValue());

                NodeList imageurlList = fstElmnt.getElementsByTagName("item_image");
                Element imageurlElement = (Element) imageurlList.item(0);
                imageurlList = imageurlElement.getChildNodes();
                imageurl[i].setText("imageurl is = " + ((Node) imageurlList.item(0)).getNodeValue());

                layout.addView(id[i]);
                layout.addView(imageurl[i]);
            }
        } catch (Exception e) {
            System.out.println("XML Pasing Excpetion = " + e);
        }

        /** Set the layout view to display */
        setContentView(layout); 
    }
}