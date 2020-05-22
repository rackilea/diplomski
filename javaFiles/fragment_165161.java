void parse_ExamList()
{

ArrayList<HashMap<String, String>> menuItems = new ArrayList<HashMap<String, String>>();
    XMLParser parser = new XMLParser();
    Document doc = parser.getDomElement(xmlContent); // getting DOM element

    //list object to populate spinner
    List<String> list = new ArrayList<String>();

    NodeList nl = doc.getElementsByTagName(KEY_EXAMSET);
    // looping through all item nodes <item>
    for ( int i = 0; i < nl.getLength();i++) {



    // creating new HashMap
    HashMap<String, String> map = new HashMap<String, String>();

    Element e = (Element) nl.item(i);
    // adding each child node to HashMap key => value
    //map.put(KEY_EXAMSET, parser.getValue(e, KEY_EXAMSET));
    map.put(KEY_SETID, parser.getValue(e, KEY_SETID));
    map.put(KEY_SETNAME, parser.getValue(e, KEY_SETNAME));
    //adding items to spinners
    list.add("("+parser.getValue(e, KEY_SETID)+") "+parser.getValue(e, KEY_SETNAME));
    menuItems.add(map);
    }

    //populating the spinner with the list items
    ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
    android.R.layout.simple_spinner_item, list);
    dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    exam_list_spinner.setAdapter(dataAdapter);

    }