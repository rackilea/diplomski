private XMLDocument doProcess() {
  XMLDocument mDoc = new XMLDocument(); // or simmilar depending on XML library
  Element rootElement = mDoc.createElement("Test");
  mDoc.appendChild(rootElement);

  // ....... I build the whole document here... 

  return mDoc; //return the document object
}