StringBuilder text;

            } else if(eventType == XmlPullParser.START_TAG) {
                text = new StringBuilder();
            } else if(eventType == XmlPullParser.TEXT) {
                if (text != null) {
                    text.append(xpp.getText());
                }
            } else if(eventType == XmlPullParser.END_TAG) {
                if (text != null) { 
                    String s = text.toString();
                    try {
                        int n = Integer.parseInt(s);
                        // do something with number n
                    } catch (NumberFormatException e) {
                        // No number
                    }
                    text = null;
                }
            }