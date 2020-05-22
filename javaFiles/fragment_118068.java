try {
            SaajSoapMessageFactory messageFactory = new SaajSoapMessageFactory(
                    MessageFactory.newInstance());
            messageFactory.afterPropertiesSet();

            WebServiceTemplate webServiceTemplate = new WebServiceTemplate(
                    messageFactory);
            Jaxb2Marshaller marshaller = new Jaxb2Marshaller();

            marshaller.setContextPath("PACKAGE");
            marshaller.afterPropertiesSet();

            webServiceTemplate.setMarshaller(marshaller);
            webServiceTemplate.afterPropertiesSet();

            Response response = (Response) webServiceTemplate
                    .marshalSendAndReceive(
                            "address",
                            searchFlights);

            Response msg = (Response) response;
        } catch (Exception s) {
            s.printStackTrace();
        }