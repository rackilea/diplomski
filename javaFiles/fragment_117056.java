railsComponent.getRailOffer().getRailProducts().stream()
    .flatMap(rp -> rp.getFareBreakdownList().stream())
    .flatMap(fb -> fbl.getPassengerFareList().stream())
    .flatMap(pf -> pfl.getPassengerSegmentFareList().stream())
    .map(psf -> psf.getCarrierServiceClassDisplayName())
    .findFirst()
    .orElse(null);