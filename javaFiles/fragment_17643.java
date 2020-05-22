String[] strings = new String[]{"lucene", "lucid dream"};
    final List<BytesRef> terms = new ArrayList<>();
    for(String s : strings) {
        terms.add(new BytesRef(s));
    }
    Collections.sort(terms);
    final Automaton a = DaciukMihovAutomatonBuilder.build(terms);

    for (int i = 0; i < a.getNumStates(); i++) {
        a.setAccept(i, true);
    }