model.listIndividuals().forEachRemaining(ind -> {
    System.out.println("Synonyms of instance " + ind + " are:");
    ind.listPropertyValues(isSynonymOf).forEachRemaining(val -> {
        System.out.println(" * " + val);
    });
});