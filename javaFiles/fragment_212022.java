List<ECSUSU> listOfUSUs = msccRequest.getUsedServiceUnit();
if (listOfUSUs != null) {
    return listOfUSUs.stream()
        .filter(Objects::nonNull)
        .findFirst()
        .map(usedServiceUnit -> {
                if (usedServiceUnit.getCcTime() != null && usedServiceUnit.getCcTime() > 0) {
                    return UnitType.SECONDS;
                } else {
                    return UnitType.BYTES;
                }
            })
        .orElse(/* default value */);
}