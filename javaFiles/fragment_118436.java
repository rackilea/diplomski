Element moduleRootElement = doc.addElement("Request");
if (rootElement.getName().equals("someName") {
    moduleRootElement.add(childElement.getName());
} else {
    moduleRootElement.add(rootElement.createCopy());
}