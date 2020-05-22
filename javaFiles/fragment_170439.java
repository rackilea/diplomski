public String toString() {
    String results = "{";
    for (int i = 0; i < arrayOfKeys.length; i++){
        results += "'"+arrayOfKeys[i]+"' : "+arrayOfValue[i]+",";
    }
    results+="}";

    return results;
}