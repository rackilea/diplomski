// you already have this bit
String templateText = tempLoader.getTemplateForCurrentLogin();

// now programmatically instantiate a template
Template t = new Template("t", new StringReader(templateText), new Configuration());

// now use the Spring utility class to process it into a string
// myData is your data model
String output = FreeMarkerTemplateUtils.processTemplateIntoString(template, myData);