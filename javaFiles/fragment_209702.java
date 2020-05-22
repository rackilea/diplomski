TransformerFactory transformerFactory = TransformerFactory.newInstance();
          Transformer transformer = transformerFactory.newTransformer();
          DOMSource source = new DOMSource(doc);
          StreamResult result = new StreamResult(new File("file.xml"));

          // Output to console for testing
          // StreamResult result = new StreamResult(System.out);

          transformer.transform(source, result);