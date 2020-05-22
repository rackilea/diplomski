public static void moveNameSpacesToRoot(Document document) {
    final Element rootElement = document.getRootElement();
    moveNameSpacesToRootElement(rootElement, rootElement);
}

@SuppressWarnings("unchecked")
private static void moveNameSpacesToRootElement(
    Element thisElement, Element rootElement) {
    if (!thisElement.equals(rootElement)) {
        Namespace namespace = thisElement.getNamespace();
        if (!namespace.equals(Namespace.NO_NAMESPACE)) {
            Namespace existingRootNamespace = 
                  rootElement.getNamespaceForPrefix(namespace.getPrefix());
            if (existingRootNamespace == null) {
                rootElement.add(namespace);
            }
            thisElement.remove(namespace);
        }
    }
    for (Element child : (List<Element>) thisElement.elements()) {
        moveNameSpacesToRootElement(child, rootElement);
    }
}