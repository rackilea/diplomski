MbMessage outMessage = new MbMessage();
        //copy message headers if required 
        MbElement oRoot = outMessage.getRootElement();  
        MbElement oBody = oRoot.createElementAsLastChild(MbBLOB.PARSER_NAME);  
        oBody.createElementAsLastChild(MbElement.TYPE_NAME_VALUE, "BLOB", yourXmlAsByteArray);
        MbMessageAssembly outAssembly = new MbMessageAssembly(inAssembly, inAssembly.getLocalEnvironment(), inAssembly.getExceptionList(), outMessage);