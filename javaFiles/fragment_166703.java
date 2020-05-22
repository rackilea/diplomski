public static boolean xmlValidationWithXSD(String xmlLocation){
                Source xmlFile = new StreamSource(new File(xmlLocation));

                 //IMPORTANT:  Here is what you need.  Multiple XSDs (that relate to each other) AND getResource will access form .jar files
                //Treat XSD as resource found in the class path, assume that the full package name is passed in xsdLocation
                Source schemaFileSource1 = new StreamSource(BenefitEnrollmentRequestFileUtil.class.getResource(NEW_XSD_FILE_RESOURCE1).toString());
                Source schemaFileSource2 = new StreamSource(BenefitEnrollmentRequestFileUtil.class.getResource(NEW_XSD_FILE_RESOURCE2).toString());
                Source[] schemaFileSources = {schemaFileSource1, schemaFileSource2};  


                SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

                try {
                    Schema schema = schemaFactory.newSchema(schemaFileSources);
                    Validator validator = schema.newValidator();
                    validator.validate(xmlFile);
                    return true;
                } catch (SAXException e) {
                    LOGGER.debug(xmlFile.getSystemId() + " is NOT valid", e);
                    LOGGER.debug("Reason: " + e.getLocalizedMessage());
                } catch (IOException e) {
                    LOGGER.debug(xmlFile.getSystemId() + " is NOT valid", e);
                    LOGGER.debug("Reason: " + e.getLocalizedMessage());                 
                }
                return false;
            }