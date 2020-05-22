ObjectIdentifier dnOid = new ObjectIdentifier("1.3.6.1.4.1.311.88.2.1");
ObjectIdentifier ddOid = new ObjectIdentifier("1.3.6.1.4.1.311.88.2.2");
ASN1Set nameSet = new DERSet(new ASN1Encodable[] {new DERPrintableString("name")});
ASN1Set descriptionSet = new DERSet(new ASN1Encodable[] {new DERPrintableString("description"}));
Attribute documentName = new Attribute(dnOid, nameSet);
Attribute documentDescription = new Attribute(ddOid, descriptionSet);