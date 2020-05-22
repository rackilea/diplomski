Map<Entity, Set<Funder>> initMap = pprsToBeApproved.stream()
    .collect(Collectors.groupingBy(
        fr -> fr.getBuyerIdentification().getBuyer().getEntity(),
        Collectors.mapping(
            fr -> fr.getDocuments().get(0).getFunder(),
            Collectors.toSet())));