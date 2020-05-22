TermEnum te = reader.terms(new Term("field", "app"));
    List<Term> termList = new LinkedList<Term>();       
    while(te.next()) {
        Term t = te.term();
        if (!t.field().equals("field") || !t.text().startsWith("app")) {
            break;
        }
        termList.add(t);
    }
    Term[] terms = termList.toArray(new Term[0]);