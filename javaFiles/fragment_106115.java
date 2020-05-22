HashMultimap hmm = HashMultimap.create();
    HashMultimap hmm2 = HashMultimap.create();
    Element ele = new Element();
    hmm2.put("name", "Amit");
    hmm.put("Amit", ele);
    hmm.put("rohit", hmm2);
    Iterator itr = hmm.keys().iterator();
    String ky = (String) itr.next();

    Set elements = hmm.get(ky);
    Iterator elementsItr = elements.iterator();
    Object val = elementsItr.next();
    if (val instanceof Element) {
        doElementStuff((Element) val);
    }

    ky = (String) itr.next();
    elements = hmm.get(ky);
    elementsItr = elements.iterator();
    val = elementsItr.next();
    if (val instanceof Element) {
        doElementStuff((Element) val);
    }