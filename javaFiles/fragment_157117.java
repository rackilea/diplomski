String reqXml                           = "" ;      

        String creditCardNumber                 = "1234567890128899" ;      

        reqXml = "<RentalPaymentPref>" +
        "<PaymentCard CardType=\"1\" CardCode=\"VI\" CardNumber=\""+creditCardNumber+"\" ExpireDate=\"0912\" SeriesCode=\"123\">" +
        "<CardHolderName>Ruchira kariyawasam</CardHolderName>" +
        "</PaymentCard>" + 
        "</RentalPaymentPref>" ;        

        StringBuffer reqXmlString = new StringBuffer(reqXml.toString());    

        short startIndex    = (short)(reqXml.indexOf("CardNumber")+12);


       if(null!=creditCardNumber && (!creditCardNumber.equals("")))
        {
            reqXmlString.replace(startIndex,(startIndex+12),"xxxxxxxxxxxx");            
        }    

        System.out.println("reqXmlString---->"+reqXmlString);


// Remaining file writing code goes here.