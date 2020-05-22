Comment comment = document.createComment("My Comment for this XML File");
document.appendChild(comment);
ProcessingInstruction processingInstruction = document.createProcessingInstruction("TSMKey", "applanguage=\"EN\" appversion=\"4.3.0\" dtdversion=\"1.6.2\"");
document.appendChild(processingInstruction);
Element rootElement = document.createElement("TOP");
document.appendChild(rootElement);