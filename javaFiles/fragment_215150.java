public void send_request( ClientRequestInfo ri )
{
    if(ri.operation().equals( "processPayment" ))
    {
        System.out.println( "################# CLIENT SIDE ###############" );
        int count = 0;
        for(Parameter param : ri.arguments())
        {
            System.out.println( "Arg : "+count );
            System.out.println( param.argument.extract_string());
            param.argument.insert_string( EncryptionDecryption.encrypt( param.argument.extract_string() ) );
            count++;
        }
    }
    System.out.println( "Arguments.." );
    logger( ri, "send_request" );
}