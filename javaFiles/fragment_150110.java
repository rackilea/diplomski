FromHeader fromHeader = (FromHeader) req.getHeader("From");
Address fromAddress = fromHeader.getAddress();
URI fromURI = fromAddress.getURI();
if (fromURI.isSipURI()) {
  SipURI fromSipURI = (SipURI) fromURI;
  extension = fromSipURI.getUser();
}