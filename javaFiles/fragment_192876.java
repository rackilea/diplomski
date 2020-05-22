Reference ref = fac.newReference("#object",fac.newDigestMethod(DigestMethod.SHA1, null));

Document doc = dbf.newDocumentBuilder().parse(new FileInputStream("C:\\myfile.xml"));
XMLStructure content = new DOMStructure(doc.getDocumentElement());
XMLObject obj = fac.newXMLObject(Collections.singletonList(content), "object", null, null);

DOMSignContext dsc = new DOMSignContext(keyEntry.getPrivateKey(), doc);
XMLSignature signature = fac.newXMLSignature(si, ki, Collections.singletonList(obj), null, null);