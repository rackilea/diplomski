ServiceClient sc = new ServiceClient();
Options opt= new Options();

//set the target EP
opt.setTo(new EndpointReference("http://localhost:8080/axis2/services/CountryService"));
opt.setAction("urn:getCountryDetails");
sc.setOptions(opt);



sc.sendReceiveNonBlocking(payload, callBack);