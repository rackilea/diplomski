Map<String, InsuranceProductDto> offerProductMap = insuranceSession.getOffer().getProducts()
        .stream()
        .filter(this::validateOfferProduct)
        .collect(Collectors.toMap(InsuranceProductDto::getObjectName, Function.identity(), 
                     (a,b) -> {// logic to merge and return value for same keys
                            }));