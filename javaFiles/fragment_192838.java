public void characters(char[] ch, int start, int length) throws SAXException
{
  _currentElementValue += new String(ch, start, length);

  Log.d(TAG, _currentElementValue);
}