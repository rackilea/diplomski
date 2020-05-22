XStream xstream = new XStream();
xstream.alias("storage", Storage.class);
xstream.alias("repository", Map.class);
xstream.registerConverter(new MapEntryConverter());
Storage storage = (Storage) xstream.fromXML(fis);
System.out.println(storage);