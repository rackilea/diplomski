final XStream xstream = new XStream(new StaxDriver());
xstream.alias("MyCustomNote", Note.class);
xstream.aliasField("toAddress", Note.class,"to");
xstream.aliasField("fromName", Note.class,"from");
xstream.aliasField("heading", Note.class,"heading");
xstream.aliasField("output", Note.class,"body");