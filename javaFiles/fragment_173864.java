Document doc = parse(xmlSource);

Document targetDoc = openTargetDoc();
Node copyTo = findWhereYouWantToCopyStuffTo(targetDoc);

// Find the node or nodes to want to copy.. could use XPath or some other search
NodeList studentinfoList = doc.getElementsByTagName("studentinfo");

// for each found... make a copy (via importNode) and attach to some point in the target doc
for( int i = 0; i < studnetinfoList.getLength(); i ++ ){
    Node n = studentinfoList.item(i);
    Node copyOfn = targetDoc.importNode(n,true);
    copyTo.appendChild(copyOfn);
}