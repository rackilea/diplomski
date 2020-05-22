int eventType = -1;
while(eventType != XmlResourceParser.END_DOCUMENT)
{
    XmlResourceParser assurances = getResources().getXml(R.xml.assurances); 
    String name = assurances.getText();
    Log.d(TAG, name);

    try {
        if (assurances.getEventType() == XmlResourceParser.START_TAG) {
            String s = assurances.getName();

            if (s.equals("assurance")) {
                assurances.next();   /// moving to the next node
                if(assurances.getName() != null && assurances.getName().equalsIgnoreCase("message")){
                    String strMessage = assurances.getText();  ///to get value getText() method should be used
                    assurances.next();   ///jumping on to the next node
                String strReference = assurances.getText();  ////similar to above
            }

                Log.d(TAG, strMessage);
                Log.d(TAG, strReference);
            }
        }
    } catch (XmlPullParserException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}