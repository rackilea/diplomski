COSStream cs = doc.getDocument().createCOSStream();
OutputStream os = cs.createOutputStream();

Result outputTarget = new StreamResult(os);
Transformer t = TransformerFactory.newInstance().newTransformer();
t.transform(new DOMSource(xmlDoc), outputTarget);

PDXFAResource resout = new PDXFAResource(cs);

aform.setXFA(resout);
os.close();
doc.save( "test.pdf" );