private static DSSeMPeople service = null;  
private DsSemPeoplePort getPort() throws Exception
{   
    String wsdl = AppUtil.getWebXmlParameter( "peopleWsdl" );
    String endpoint = AppUtil.getWebXmlParameter( "peopleEndpoint" );
    if( wsdl==null || "".equals(wsdl) ) {
        wsdl = endpoint;
    }

    try { 
        if( service==null ) {

            log.info( "create peopleService from wsdl: " + wsdl );              
            log.info( "use peopleService endpoint: " + (endpoint==null?"(from wsdl)":endpoint) );

            URL url = new URL( wsdl );              
            service = new DSSeMPeople( url, new QName( "http://www.tudelft.nl/domain/sem/people_2_0/", "DS_SeM_People") );
        }

        DsSemPeoplePort port = service.getDsSemPeoplePort();

        // set endpoint
        if( endpoint!=null && !"".equals(endpoint) && !endpoint.equals(wsdl) ) {

            BindingProvider provider = (BindingProvider) port;
            provider.getRequestContext().put( BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpoint );
        }

        return port;

    } catch (Exception e) {

        String msg = "Failed to connect to people webservice. ";
        log.error( msg );
        throw new Exception( msg, e );
    }       
}