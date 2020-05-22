static Set<Element> getAnnotatedElements(
    Elements elements,
    TypeElement type,
    Class<? extends Annotation> annotation)
{
    Set<Element> found = new HashSet<Element>();
    for (Element e : elements.getAllMembers(type)) {
        if (e.getAnnotation(annotation) != null)
            found.add(e);
    }
    return found;
}