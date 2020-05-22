Element production = docX2.createElement("PRODUCTION");
                try {
                    TransformerFactory factory = TransformerFactory.newInstance();
                    Source xslt = new StreamSource("slimmer.xslt");
                    Transformer transformer = factory.newTransformer(xslt);
                    Source text = new DOMSource(docX1);                    
                    transformer.transform(text, new DOMResult(production));                    
                } catch (Exception ex) {
                    Logger.getLogger(IntProcess.class.getName()).log(Level.SEVERE, null, ex);
                }
                root.appendChild(production);