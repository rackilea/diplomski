Concept stand = new Concept(getSynset("stand#v#1"), POS.v);
Concept jump = new Concept(getSynset("jump#v#1"), POS.v);
double score = compare(comparer, co, stand);
// done!    

// utility
private static double compare(RelatednessCalculator comparer, Concept one,
        Concept other) throws Exception {
    Relatedness res = comparer.calcRelatednessOfSynset(one, other);
    if(StringUtils.isNotBlank(res.getError()))
    {
        throw new Exception ("WordNET similiarity for " + one + " and " + other + " failed with this error: "+ res.getError() + "\n" + res.getTrace());
    }
    return res.getScore();
}

/**
 * 
 * @param wordnetword a string of the format lemma#pos#num. E.g. jump#v#1 or house#n#2
 * @return a synset identifier for WS4J
 */
private static Concept getSynset(String wordnetword) {
    String[] parts = StringUtils.split(wordnetword, "#");
    String lemma = parts[0];
    POS mypos = POS.valueOf(parts[1]);
    int index = Integer.parseInt(parts[2]) - 1;
    List<Synset> synsets = WordNetUtil.wordToSynsets(lemma, mypos);
    Synset synset = synsets.get(index);
    String synstring = synset.getSynset();
    return new Concept(synstring, mypos, lemma, synset.getSrc());
}