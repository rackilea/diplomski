class ImprovedSoapClient extends SoapClient
{
    public function __construct($wsdlLocation)
    {
        parent::__construct(
            $wsdlLocation 
            , array(
                , 'cache_wsdl' => WSDL_CACHE_NONE
                , 'stream_context'=>stream_context_create(
                    array('http'=>
                        array(
                            'protocol_version'=>'1.0'
                            , 'header' => 'Connection: Close'
                        )
                    )
                )
            )
        );
    }
}