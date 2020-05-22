String myName = "";
if(myArrayString != null) {
    myName = Arrays.stream(myArrayString)
                        .map(tagManager::resolve)
                        .filter(Objects::nonNull)
                        .map(x -> resolveTagName(x.getName()))
                        .collect(joining(" "));
    myName = myName.substring(myName.lastIndexOf("/") + 1);
    return myName;
}