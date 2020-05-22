SOAPElement timestamp = secHeader.addChildElement(soapFactory.createName("Timestamp", "u", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd"));
//[add 'Created' and 'Expires' values, as required]

//once you're done adding stuff, you can canonicalize the element
Canonicalizer canonizer = Canonicalizer.getInstance(Canonicalizer.ALGO_ID_C14N_EXCL_OMIT_COMMENTS);
byte[] canonTimestamp = canonizer.canonicalizeSubtree(timestamp);