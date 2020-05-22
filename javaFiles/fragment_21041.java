Query q = QueryFactory.create(query); // SPARQL 1.1

// Remember distinct subjects in this
final Set<Node> subjects = new HashSet<Node>();

// This will walk through all parts of the query
ElementWalker.walk(q.getQueryPattern(),
    // For each element...
    new ElementVisitorBase() {
        // ...when it's a block of triples...
        public void visit(ElementPathBlock el) {
            // ...go through all the triples...
            Iterator<TriplePath> triples = el.patternElts();
            while (triples.hasNext()) {
                // ...and grab the subject
                subjects.add(triples.next().getSubject());
            }
        }
    }
);