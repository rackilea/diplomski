public String expressionConstruct(String jsonWithOutFormat) {

    jsonWithOutFormat = jsonWithOutFormat.replaceAll(" ", "");
    String json = "";
    String[] objectsInString = jsonWithOutFormat.split("[{]");
    List<String> nestedObjects = new ArrayList<>();
    json += "{";
    for (int i = 0; i < objectsInString.length; i++) {
        String[] objectAttributes = objectsInString[i].split("[,]");
        if(i==0)
            nestedObjects.add(objectAttributes[objectAttributes.length-1] + ".");
        else
            nestedObjects.add(nestedObjects.get(i-1)+objectAttributes[objectAttributes.length-1] + ".");
        for (int j = 0; j < objectAttributes.length; j++) {
            if(!(j == objectAttributes.length-1)) {
                if(i != 0)
                    json+=  objectAttributes[j].replaceAll("}", "") + ": " +  nestedObjects.get(i-1) + objectAttributes[j]  + ", ";
                else
                    json+=  objectAttributes[j] + ": " + objectAttributes[j] + ", ";
            }
            else {
                if(!(i == objectsInString.length-1))
                    json+=  objectAttributes[j] + ": {";
                else {
                    json+= objectAttributes[j].replaceAll("}", "")  + ": " + nestedObjects.get(i-1) + objectAttributes[j];
                }
            }
        }
    }
    json += "}";
    return json;

}