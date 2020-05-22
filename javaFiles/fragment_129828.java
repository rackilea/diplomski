soapEnvelope.setOutputSoapObject(request);

        System.setProperty("http.keepAlive", "false");

        HttpTransportSE htse = new HttpTransportSE(URL, 60000);

        //htse.debug=true; //This directive is helpful while debugging
        try {
            htse.call(URL, soapEnvelope, null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        if (soapEnvelope.bodyIn instanceof SoapFault) {
            Node details = ((SoapFault) soapEnvelope.bodyIn).detail;
            Element detailElem = (Element) details.getElement(0).getChild(0);
            String exc = detailElem.getName();
            if (exc.equals("SomeSpecificException")) {
                throw new SomeSpecificException();
            }
            throw new Exception("SOAP PROBLEMS!");
        }