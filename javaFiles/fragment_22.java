Map data = new HashMap();
// Add data to your map here

StringWriter writer = new StringWriter();
VelocityContext velocityContext = new VelocityContext(data);
velocityEngine.mergeTemplate(templateLocation, velocityContext, writer);
String html = writer.toString();