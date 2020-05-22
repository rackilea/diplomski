// write the freemarker output to a StringWriter 
StringWriter stringWriter = new StringWriter();
template.process(prepareData(), stringWriter);

// get the String from the StringWriter
String string = stringWriter.toString();