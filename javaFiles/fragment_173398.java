List<String> chainIds =
    consultationRestaurant.getAddressees()
        .stream()
        .map( ma -> chainRestService.getClient().getChainDetails(getTDKUser(), ma.getChain().getId()))
        .filter(chain -> chain.getOrganisation().getId().equalsIgnoreCase(event.getOrganisationId()))
        .map(Chain::getId)
        .collect(Collectors.toList());