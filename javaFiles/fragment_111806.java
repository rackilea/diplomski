int eventType = parser.getEventType();
Log.i("TAG", "The event type is: " + eventType);

while (eventType != XmlPullParser.START_DOCUMENT) {
    eventType = parser.next();            
    Log.i("TAG", "The event type is: " + eventType);
}