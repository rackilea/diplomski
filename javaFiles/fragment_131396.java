private static final Name SECURITY_DATA = new Name("securityData");
private static final Name FIELD_DATA = new Name("fieldData");

Element securityDataArray = msg.getElement(SECURITY_DATA); // msg is a Bloomberg desktop API object
Element securityData = securityDataArray.getValueAsElement(0);
Element fieldData = securityData.getElement(FIELD_DATA);
Element field = fieldData.getElement(0); 

/* the above codes were known at the time of the question */
/* below is what I was shown by a bloomberg representative */

Element bulkElement = field.getValueAsElement(0);
Element elem = bulkElement.getElement(0);
out.write(elem.name() + "\t" + elem.getValueAsString() + "\n");