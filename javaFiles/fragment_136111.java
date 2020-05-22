private static List<Fact> sumFacts(List<Fact> facts) {
    Map<String, Fact> summedFacts = new HashMap<Fact>();

    for (Fact fact : facts) {
        summedFact = summedFacts.get(fact.getReportingDate());
        if (summedFact == null) {
            summedFacts.put (fact.getReportingDate(), fact);
        } else {
            summedFact.setNumberSaved(summedFact.getNumberSaved() + fact.getNumberSaved());
        }
    }
    return new ArrayList<Fact>(summedFacts.values());
}