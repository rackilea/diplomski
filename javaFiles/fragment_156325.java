Map<Entity, List<Funder>> initMap = pprsToBeApproved.stream()
    .collect(Collectors.groupingBy(
        fr -> fr.getBuyerIdentification().getBuyer().getEntity(), // group by this
        Collectors.mapping(
            fr -> fr.getDocuments().get(0).getFunder(), // mapping each element to this
            Collectors.toList())));                     // and putting them in a list