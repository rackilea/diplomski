Iterator<Element> iter1 = elements1.iterator();
Iterator<Element> iter2 = elements2.iterator();
while (iter1.hasNext() && iter2.hasNext()) {
    Element element1 = iter1.next();
    Element element2 = iter2.next();
    // code here
}