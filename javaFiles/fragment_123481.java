JAXBContext jc = JAXBContext.newInstance( PACKAGE );
Unmarshaller m = jc.createUnmarshaller();
try {
    File source = new File( XMLIN );
    JAXBElement<ResultType> jbe = (JAXBElement<ResultType>)m.unmarshal( source );
ResultType result = (ResultType)jbe.getValue();
} catch( Exception e ){
}