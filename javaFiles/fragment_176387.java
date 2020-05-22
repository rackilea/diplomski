XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        factory.setNamespaceAware(true);
        XmlPullParser xpp = factory.newPullParser();
        xpp.setInput(new StringReader(response));
            String value = null;

        while(xpp.getEventType() !=XmlPullParser.END_DOCUMENT){ // loop from the beginning to the end of the XML document

            if(xpp.getEventType()==XmlPullParser.START_TAG){

                if(xpp.getName().equals("version")){
                    // start tag : <version>
                                    // do some stuff here, like preparing an 
                                    // object/variable to recieve the value "1" of the version tag
                }
            }
            else if(xpp.getEventType()==XmlPullParser.END_TAG){             

                       // ... end of the tag: </version> in our example             
                }
                    else if(xpp.getEventType()==XmlPullParser.TEXT){ // in a text node
                 value = xpp.getText(); // here you get the "1" value 
        }

        xpp.next(); // next XPP state
    }