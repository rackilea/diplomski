final SAXParserFactory factory = SAXParserFactory.newInstance();
final SAXParser parser = factory.newSAXParser();

final RecorderProxy recorder = new RecorderProxy(parser.getXMLReader());
final ClipHolder clipHolder = new ClipHolder(recorder);

clipHolder.parse(new InputSource(new StringReader(srcXml)));

assertTrue(recorder.hasRecordingToReplay());

final Clip clip = clipHolder.getClip();
assertNotNull(clip);
assertEquals(clip.title, "My Title");
assertEquals(clip.category, "Blah!");
assertEquals(clip.date, Clip.DATE_FORMAT.parse("12/24/2012"));

clip.title = "My Title Updated";
clip.category = "Something else";

final ClipSerializer serializer = new ClipSerializer(recorder);
serializer.setClip(clip);

final TransformerFactory xsltFactory = TransformerFactory.newInstance();
final Transformer t = xsltFactory.newTransformer();
final StringWriter outXmlBuffer = new StringWriter();

t.transform(new SAXSource(serializer, 
            new InputSource()), new StreamResult(outXmlBuffer));

assertEquals(targetXml, outXmlBuffer.getBuffer().toString());