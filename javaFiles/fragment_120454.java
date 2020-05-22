StringBuilder mSb;
   boolean isBuilding;

   @Override
   public void startElement(String uri, String localName, String qName,
         Attributes attributes) throws SAXException {

        mSb = new StringBuilder();
        isBuilding = true;

        if(qName.equals("title")){
            parsingTitle = true;
        }
        ...
        ...
    }

    @Override
    public void characters (char ch[], int start, int length) {
        if (mSb !=null && isBuilding) {
            for (int i=start; i<start+length; i++) {
                mSb.append(ch[i]);
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)
        throws SAXException {

        if(parsingTitle){
            currentItem.setTitle(sb.toString().trim());
            parsingTitle = false;  
            isBuilding = false;
        }
    }