odataUri : serviceRoot? EOF  ;

serviceRoot : Protocol host segments relative? # OnSerivceRoot ;

segments    : Segments ;

host         : (addr | regName) port?;
addr         : ColSlaSla IPv4address ;

regName      : HOST ;

port          : PortDef ;

relative : (ODataSignal_METADATA | ODataSignal_BATCH) | odataRelativeUri;

odataRelativeUri : resourcePath ( question queryOptions )?;
question : QUESTION ;


PortDef     : COLON Digits ;
Segments    : SLASH ((Unreserved | PctEncoded | SubDelims | COLON | AT_SIGN)+ SLASH)* ;
HOST         : ColSlaSla HOST_DEF ;
HOST_DEF     : (Unreserved | PctEncoded | SubDelims)+ ;
QUESTION : '?';
Protocol :  HttpOrHttpsAnyCase;
Digits  : Digit+ ;
Digit  : [0-9] ;
Alpha  : [a-zA-Z];