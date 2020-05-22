if (envelope.bodyIn instanceof SoapFault) {
        String str= ((SoapFault) envelope.bodyIn).faultstring;
        Log.i("", str);

        // Another way to travers through the SoapFault object
    /*  Node detailsString =str= ((SoapFault) envelope.bodyIn).detail; 
        Element detailElem = (Element) details.getElement(0) 
                     .getChild(0); 
        Element e = (Element) detailElem.getChild(2);faultstring; 
        Log.i("", e.getName() + " " + e.getText(0)str); */
    } else {
        SoapObject resultsRequestSOAP = (SoapObject) envelope.bodyIn;
        Log.d("WS", String.valueOf(resultsRequestSOAP));
    }