Unmarshaller unmarshaller = jc.createUnmarshaller();
    Object result = unmarshaller.unmarshal(reader);
    Message msg = (Message)result;
    if (msg.getObj() instanceof Node) {
        ElementNSImpl e = (ElementNSImpl)msg.getObj();
        Class<?> clazz = Class.forName(packageName.concat(".").concat(e.getNodeName()));
        jc = JAXBContext.newInstance(clazz);
        unmarshaller = jc.createUnmarshaller();
        SomeBean sBean = (SomeBean)unmarshaller.unmarshal((ElementNSImpl)msg.getObj());
        System.out.println(sBean.toString());
    }