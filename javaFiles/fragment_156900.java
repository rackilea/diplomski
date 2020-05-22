...
 case XmlPullParser.START_TAG:
     if (tagname != null && tagname.equals(iconsrc)){
        iconsrcVALUE = parser.getAttributeValue(0);
        new AsyncForBitmap(IV).execute(iconsrcVALUE);
     }
     break;