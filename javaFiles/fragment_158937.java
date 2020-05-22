Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        jaxbUnmarshaller.setSchema(schema);
        MyValidationEventHandler myValidationEventHandler();
        jaxbUnmarshaller.setEventHandler(myValidationEventHandler);
        jaxbUnmarshaller.unmarshal(xml);
        myValidationEventHandler.getMyState();