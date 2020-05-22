if (pulled.equals("preset")) {
    presetName = xmlParser.getAttributeValue(null,"name");
    if (xmlParser.getEventType() == XmlPullParser.TEXT) {
       Log.d(TAG, presetName + " = " + xmlParser.getText());
    }
}