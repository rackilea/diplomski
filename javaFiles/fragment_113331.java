IndexReader reader = IndexReader.open(index);
TermEnum terms = reader.terms();
Set<String> uniqueTerms = new HashSet<String>();
while (terms.next()) {
        final Term term = terms.term();
        if (term.field().equals("field_name")) {
                uniqueTerms.add(term.text());
        }
}