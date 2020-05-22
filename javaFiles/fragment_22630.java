try{
    validator.validate(xmlFile);
    System.out.println(xmlFile.getSystemId()+ " is valid");
    System.out.println();
} catch (SAXParseException e) 
{
    System.out.println(schemaFile.getSystemId() + " is NOT valid");
    System.out.println("Reason: " + e.getMessage() 
         + " at line:" + e.getLineNumber() 
         + " at column:" + e.getColumnNumber() +".");
} catch (SAXException e) 
{
    System.out.println(schemaFile.getSystemId() + " is NOT valid");
    System.out.println("Reason: " + e.getMessage());
}