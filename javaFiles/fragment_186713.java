JAXBContext jaxbContext = JAXBContext.newInstance(MyClass.class);
Marshaller marshaller = jaxbContext.createMarshaller();
marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

marshaller.marshal(new MyClass(Math.PI, null), System.out);
marshaller.marshal(new MyClass(Double.NaN, new Foo()), System.out);