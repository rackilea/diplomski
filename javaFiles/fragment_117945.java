SoapObject soapObject = new SoapObject(NameSpace, MetodeName);
        soapObject.addProperty("Subject", objSubject);
        soapObject.addProperty("Content", objContent);

        SoapObject messageFileHeader = new SoapObject(NameSpace,"messagefile");

        for (int i = 0; i < structureAttaches.size(); i++) {
            MessageFile messageFile = new MessageFile(structureAttaches.get(i).getName(), structureAttaches.get(i).getBase64File(), structureAttaches.get(i).getFileExtension());
            messageFileHeader.addProperty("MessageFile", messageFile);
        }

        SoapObject receiverHeader = new SoapObject(NameSpace,"receiver");

        for (int i = 0; i < structureUserAndRole.size(); i++) {
            Receiver receiver = new Receiver(structureUserAndRole.get(i).getRole_ID(),structureUserAndRole.get(i).getUser_ID());
            receiverHeader.addProperty("Receiver", receiver);
        }

        soapObject.addSoapObject(messageFileHeader);
        soapObject.addSoapObject(receiverHeader);