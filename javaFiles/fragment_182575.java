...
Document document = documentBuilder.newDocument();

Element rootElement = document.createElement("xsl:stylesheet");
// adding attributes like namespaces etc...

document.appendChild(rootElement); 
Element em = document.createElement("xsl:template");
em.setAttribute("match", "/");