final Map<String, Object> jaxbContextProps = new HashMap<String, Object>();
    jaxbContextProps.put(JAXBContextProperties.OXM_METADATA_SOURCE, "binding.json");
    jaxbContextProps.put(JAXBContextProperties.MEDIA_TYPE, "application/xml");

    final Map<String, Object> marshallerProps = new HashMap<String, Object>();
    marshallerProps.put(Marshaller.JAXB_FORMATTED_OUTPUT, true);

    final Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
    marshaller.setLazyInit(true);
    marshaller.setClassesToBeBound(Pojo.class);
    marshaller.setJaxbContextProperties(jaxbContextProps);
    marshaller.setMarshallerProperties(marshallerProps);

    Pojo pojo = new Pojo();
    pojo.set("message", "This is some message");
    pojo.set("shouldValidate", "Yes");
    pojo.set("buffer", "1000");

    StringWriter writer = new StringWriter();
    StreamResult streamResult = new StreamResult(writer);
    marshaller.marshal(pojo,  streamResult);
    //System.out.println(writer.toString());