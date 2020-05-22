DictionaryProvince dp = new DictionaryProvince( "id", "prov", "code" );
JAXBContext jc = JAXBContext.newInstance( PACKAGE );
Marshaller m = jc.createMarshaller();
JAXBElement<DictionaryProvince> jbe;
jbe = wrap( null, "Province", dp );
m.marshal( jbe, sw );