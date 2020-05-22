for(String s : a.List){
    Element n = doc.createElement("value");
    if(s != null) {
        n.appendChild(doc.createTextNode(s)); // only append non-null values
    }
}