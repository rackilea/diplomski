Document doc = webView.getEngine().getDocument();
URL scriptUrl = getClass().getResource(pathToAttachedDocument); // pathToAttachedDocument = CSS file you want to attach
String content = IOUtils.toString(scriptUrl); // Use Apache IO commons for conveniance
Element appendContent = doc.createElement("style");
appendContent.appendChild(doc.createTextNode(content));
doc.getElementsByTagName("head").item(0).appendChild(appendContent);