ExtendedIterator<Individual> indIter = model.listIndividuals();
while(indIter.hasNext()) {
    Individual ind = indIter.next();
    System.out.println("Synonyms of instance " + ind + " are:");
    NodeIterator valueIter = ind.listPropertyValues(isSynonymOf);
    while(valueIter.hasNext()) {
        RDFNode val = valueIter.next();
        System.out.println(" * " + val);
    }
}