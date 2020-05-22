Element root = document.getDocumentElement();
if (root.hasChildNodes()) {
    Node firstChild = root.getFirstChild();
    root.insertBefore(document.createElement("first-name"), firstChild);
} else {
    // Append to as per previous example
}