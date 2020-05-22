UrlParser parser = new Parser();
parser.setTemplate("/item/{INT:itemID}/{STRING:itemAttribute}");
UrlParametersMap upm = parser.parse(request.getURI());
boolean attributeExists = upm.parameterExists("itemAttribute");
String attribute = null;
if(attributeExists){
  attribute = upm.getString("itemAttribute");
}