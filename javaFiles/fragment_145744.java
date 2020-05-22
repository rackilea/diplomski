for (Entity s: txn.getAll("SynsetID")) {
    Comparable id = s.getProperty("synsetID");
    for (Entity g : s.getLinks("gloss")) {
        System.out.println(id + " : " + g.getProperty("gloss"));
    }
}