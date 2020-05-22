SOAPElement sigInfo = sigElem.addChildElement(new QName("SignedInfo"));
SOAPElement canon = sigInfo.addChildElement(new QName("CanonicalizationMethod"));
canon.addAttribute(soapFactory.createName("Algorithm"), Canonicalizer.ALGO_ID_C14N_EXCL_OMIT_COMMENTS);
//[continue adding the other elements...]

//canonicalize the entire, completed 'SignedInfo' block
byte[] bytesToSign = canonizer.canonicalizeSubtree(sigInfo);