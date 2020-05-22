class Handler extends DefaultHandler {

// Create three array lists to store the data
public ArrayList<Integer> lows = new ArrayList<Integer>();
public ArrayList<Integer> highs = new ArrayList<Integer>();
public ArrayList<String> regions = new ArrayList<String>();


// Make sure that the code in DefaultHandler's
// constructor is called:
public Handler() {
    super();
}


/*** Below are the three methods that we are extending ***/

@Override
public void startDocument() {
    System.out.println("Start document");
}


@Override
public void endDocument() {
    System.out.println("End document");
}

//Keeps track of the current tag;
String currentTag = "";

// This is where all the work is happening:
@Override
public void startElement(String uri, String name, String qName, Attributes atts) {
    //Save the current tag being handled
    currentTag = qName;
}

//Detect end tag
@Override
public void endElement(String uri, String localName, String qName) throws SAXException {
    //Reset it
    currentTag = "";
}

@Override
public void characters(char[] ch, int start, int length) throws SAXException {
    //Rules based on current tag
    switch (currentTag) {
        case "region":
            String region = String.valueOf(ch, start, length);
            this.regions.add(region);
            System.out.println("Day: " + region);
            break;
        case "wind_degree":
            int low = Integer.parseInt(String.valueOf(ch, start, length));
            System.out.println("Low: " + low);
            this.lows.add(low);
            break;
        case "high":
            int high = Integer.parseInt(String.valueOf(ch, start, length));
            System.out.println("High: " + high);
            this.highs.add(high);
            break;
    }
}}