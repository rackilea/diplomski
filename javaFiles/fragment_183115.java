Map<PassType, PassTypeRate> group(List<DataEntry> entries) {
        return entries.stream()
                .collect(Collectors.toMap(
                        DataEntry::getPassType,
                        entry -> PassTypeRate.builder()
                                .adultRate(entry.getAgeType() == ADULT ? entry.getRate() : BigDecimal.ZERO)
                                .childRate(entry.getAgeType() == CHILD ? entry.getRate() : BigDecimal.ZERO)
                                .build(),
                        (rate1, rate2) -> PassTypeRate.builder()
                                .childRate(rate1.getChildRate().add(rate2.getChildRate()))
                                .adultRate(rate1.getAdultRate().add(rate2.getAdultRate()))
                                .build()
                ));
    }