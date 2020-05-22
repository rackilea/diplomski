for(Integer i: indentificationDocuments.keySet()){
    // Below line could be a problem, get(i) may not exist anymore but may still be in view of the iterator
    // someStringBuilder.append(indentificationDocuments.get(i));
    // Next line would work
    someStringBuilder.append(identificationDocuments.getOrDefault(i, ""));
}