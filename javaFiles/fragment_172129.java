MySourceJaxbClass sourceObject = // ...
Transformer transformer = transformerFactory.newTransformer(xsltSource);
JAXBContext context = // however you need to create your context
Source src = new JAXBSource(context, sourceObject);
JAXBResult res = new JAXBResult(context);
transformer.transform(src, res);

MyTargetJaxbClass resultObject = (MyTargetJaxbClass)res.getResult();