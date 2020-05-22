private String getProperName(DataFolder f, String name, int suffix) {
    String actualName = name;
    if(suffix > 0) {
        actualName = actualName + "_" + suffix;
    }
    for(DataObject chld : f.getChildren()) {
        if(chld.getName().equals(actualName)) {
            suffix++;
            return getProperName(f, name, suffix);
        }
    }
    return actualName;
}