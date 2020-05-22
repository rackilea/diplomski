ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();

        String xml = XMLfunctions.getTopNewsXML();
        Document doc = XMLfunctions.XMLfromString(xml);

        int numResults = XMLfunctions.numResults(doc);
        Log.d(LOG_TAG, "Number of Results: " + numResults);
        if ((numResults <= 0)) {
            Toast.makeText(ParentActivity.this, "No Result Found",Toast.LENGTH_LONG).show();
            return null;
        }

        NodeList nodes = doc.getElementsByTagName("result");

        for (int i = 0; i < nodes.getLength(); i++) {
            HashMap<String, String> map = new HashMap<String, String>();

            Element e = (Element) nodes.item(i);
            map.put("title", XMLfunctions.getValue(e, "title"));
            mylist.add(map);
        }
        return mylist;