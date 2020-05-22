...
SoapObject result = (SoapObject) env.bodyIn;
final int size = result.getPropertyCount();
for (int i = 0; i < size; i++) {
    SoapObject tempObj = (SoapObject) result.getProperty(i);
    // accessing operations with the name name and surname
    tempObj.getPropertyAsString("name");
    tempObj.getPropertyAsString("surname");
...