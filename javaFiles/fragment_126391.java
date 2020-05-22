// Add a text node to the element
element.appendChild(doc.createTextNode("D"));

// Add a text node to the beginning of the element
element.insertBefore(doc.createTextNode("A"), element.getFirstChild());

// Add a text node before the last child of the element
element.insertBefore(doc.createTextNode("C"), element.getLastChild());

// Add another element after the first child of the root element
Element element2 = doc.createElement("item");
element.insertBefore(element2, element.getFirstChild().getNextSibling());

// Add a text node in front of the new item element
element2.getParentNode().insertBefore(doc.createTextNode("B"), element2);