Marshaller marshaller = ctx.createMarshaller();
marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");

StringWriter writer = new StringWriter(1024); // 2 KB
marshaller.marshal(obj, writer);

String str = writer.toString();
str = str.replaceAll("\r?\n", "\r\n");  // only convert if necessary