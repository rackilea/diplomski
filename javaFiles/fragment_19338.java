ASN1EncodableVector signedAttributes = new ASN1EncodableVector();
signedAttributes.add(new Attribute(CMSAttributes.contentType, new DERSet(new ASN1ObjectIdentifier("1.2.840.113549.1.7.1"))));
signedAttributes.add(new Attribute(CMSAttributes.messageDigest, new DERSet(new DEROctetString(digestBytes))));
signedAttributes.add(new Attribute(CMSAttributes.signingTime, new DERSet(new DERUTCTime(signingDate))));

AttributeTable signedAttributesTable = new AttributeTable(signedAttributes);