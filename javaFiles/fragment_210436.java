for(String s : a.List){
    if(s != null) {
        Element n = doc.createElement("value");
        n.appendChild(doc.createTextNode(s));
    }
}