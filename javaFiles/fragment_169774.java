Resource r;
Statement title, id, lpos, rpos;
while(sit.hasNext()) {
    r = sit.nextStatement().getSubject();

    title = r.getProperty(DCTerms.title);
    id    = r.getProperty(DCTerms.identifier);
    lpos  = r.getProperty(PearlTree.RDF.leftPos);
    rpos  = r.getProperty(PearlTree.RDF.rightPos);
    ...
}