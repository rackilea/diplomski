MimeMultipart mp = new MimeMultipart(new ByteArrayDataSource(InputStream, "multipart/related"));
 int count = mp.getCount();
 for (int i = 0; i < count; i++) {
     BodyPart bodyPart = mp.getBodyPart(i);
     String content = new String(read(bodyPart));

     String partContentType =  bodyPart.getContentType();


  if(partContentType.toLowerCase().contains(SOAPConstants.SOAP_1_2_CONTENT_TYPE)) {

        //process SOAP 1.2
     }

    if(partContentType.toLowerCase().contains(SOAPConstants.SOAP_1_1_CONTENT_TYPE)) {

        //process SOAP 1.1
     }

     if(partContentType.toLowerCase().contains("application/octet-stream")) {

        // process binary part
     }
 }