private List<Element> executeForEachElement(List<Element> oldList)
    List<Element> newElements = new LinkedList<Element>();
    for (Element elem : oldList {
            newElements.addAll(generateNewElements(elem));
    }
    if (!newElements.isEmpty()) {
        oldList.addAll(executeForEachElement(newElements));
    }

    return oldList;
}