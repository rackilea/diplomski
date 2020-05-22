// Parsing 'import' statements
List<Element> importElements = DomUtils.getChildElementsByTagName(myBeansElement, "import");
Resource currentResource = parserContext.getReaderContext().getResource();
for (Element importElement : importElements) {
    String importPath = importElement.getAttribute("resource");
    try {
        Resource importResource = currentResource.createRelative(importPath);
        parserContext.getReaderContext().getReader().loadBeanDefinitions(importResource);
    } catch (IOException | BeanDefinitionStoreException e) {
        e.printStackTrace();
    } 
}