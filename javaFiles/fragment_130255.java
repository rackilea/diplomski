Element destination = rootElement;
Element tag = null;
while (ait.hasNext()) {
    tag = doc.createElement((String) ait.next());
    destination.appendChild(tag);
    destination = tag;
}
destination.appendChild(doc.createTextNode(val));