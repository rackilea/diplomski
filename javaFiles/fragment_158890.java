TransformerFactory transformerFactory = TransformerFactory.newInstance();
Transformer transformer = transformerFactory.newTransformer();
transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "TEST1");
transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "TEST2");
transformer.transform(new StreamSource(new StringReader("<Root></Root>")),
                      new StreamResult(System.out));