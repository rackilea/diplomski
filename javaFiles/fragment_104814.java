try {
    Document doc = sdfbuilder.build(somexml);
    System.out.println("Parsed using sdf")
    return doc
} catch (JDOMException x) {
    // parse failed, probably wrong schema....
}

try {
    Document doc = csdfbuilder.build(somexml);
    System.out.println("Parsed using csdf")
    return doc
} catch (JDOMException x) {
    // parse failed, probably wrong schema....
}

// oops, nothing works for this document...