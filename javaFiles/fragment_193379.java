public static void main(String[] args) throws Exception {
            FileInputStream fis = new FileInputStream("SourceExternalFile.xml");        
            XMLInputFactory xmlif = null;
            xmlif = XMLInputFactory.newInstance();
            Source xslt = new StreamSource(new File("myTransformFile.xslt"));

            XMLEventReader xmlR = xmlif.createXMLEventReader(xmlif.createXMLStreamReader(fis));

            TransformerFactory transformerXSLT = TransformerFactory.newInstance();
            Transformer currentXslt = transformerXSLT.newTransformer(xslt);

            while (xmlR.hasNext())
            {
                XMLEvent xmlEvent = xmlR.nextEvent();
                if ( xmlEvent.equals("wantedTag") )
                {
                    currentXslt.transform(new StAXSource(xmlR), new StreamResult("targetFile.xml"));
                }
            }
            xmlR.close();
            fis.close();
        }