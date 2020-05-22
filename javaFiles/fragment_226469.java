private boolean validateDocs(List<Map<String, Object>> documentsList) {
    boolean isValid = true;
    StringBuilder gradoAntComp = new StringBuilder();
    for (Map<String, Object> document : documentsList) {
        String id = document.get("ID_DOC").toString();
        if (id.equalsIgnoreCase("25")) {
            // this can set isValid to either false or true
            isValid = getData(id.toString(),program().toString(), document.get(name))
        } else if (id.equalsIgnoreCase("26") ) {
            // therefore performing logical AND between the previous value of
            // isValid and some additional boolean is meaningful - isValid will
            // be assigned true only if it was true before this statement AND
            // getDocs(id.toString(),program().toString(), document.get(name)) is true
            isValid = isValid && getDocs(id.toString(),program().toString(), document.get(name));
        } 
    }
    return isValid;
}