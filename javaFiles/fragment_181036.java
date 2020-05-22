XsdSchemaCollection schemaCollection = new XsdSchemaCollection() {

        @Override
        public XsdSchema[] getXsdSchemas() {
            return null;
        }

        @Override
        public XmlValidator createValidator() {
            try {
                XmlValidator xmlValidator = XmlValidatorFactory.createValidator(getSchemas(), "http://www.w3.org/2001/XMLSchema");

                return xmlValidator;
            } catch (IOException e) {
                logger.error(e.getLocalizedMessage());
            }
            return null;
        }
    };