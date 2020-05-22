//SOAP CALL
function sayHello(){
    $client = new SoapClient('http://Server:8080/MyClassService/MyClass?WSDL');
    $response = (array) $client->glassfishHello();      
    return $response['return'];
}