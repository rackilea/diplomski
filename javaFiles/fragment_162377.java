model.read(...);
StmtIterator si = model.listStatements(
        model.getResource("required property uri"), RDFS.range, (RDFNode) null);
while (si.hasNext()) {
    Statement stmt = si.next();
    Resource range = stmt.getObject().asResource();
    // get restrictions collection
    Resource nextNode = range.getPropertyResourceValue(OWL2.withRestrictions);
    for (;;) {
        Resource restr = nextNode.getPropertyResourceValue(RDF.first);
        if (restr == null)
            break;

        StmtIterator pi = restr.listProperties();
        while (pi.hasNext()) {
            Statement restrStmt = pi.next();
            Property restrType = restrStmt.getPredicate();
            Literal value = restrStmt.getObject().asLiteral();
            // print type and value for each restriction
            System.out.println(restrType + " = " + value);
        }
        // go to the next element of collection
        nextNode = nextNode.getPropertyResourceValue(RDF.rest);
    }
}