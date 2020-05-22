case XmlResourceParser.TEXT:
if (xmlData.getText().trim().length() > 0) 
{
   itemsArray.add(xmlData.getText());
   Log.i(TAG, "a"+xmlData.getText()+"b");
}
break;