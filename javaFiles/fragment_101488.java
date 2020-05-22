String index = "search"; //yourIndex
String type  = "Customer";
String location = "resources/Customer.json";

EsUtils.client = yourClient; //pass your client
EsUtils.applyMapping(index, type, location);