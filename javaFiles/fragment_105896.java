Date date = /* get the date from the request*/
// then do something like this:
XStream xstream = new XStream();
xstream.alias("date", Date.class);
String xml = xstream.toXML(date);
// write the xml string to the file.