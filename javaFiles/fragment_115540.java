//Assuming you have constructor in OtherType with three arguments like OtherType(String storeId, String storeName, DayOfWeek day)

List<OtherType> transformed = stores.stream()
                                    .flatMap(store->store.getOpeningDays().stream()
                                                                      .map(day->new OtherType(store.getStoreId(),store.getStoreName(),day)))
                                    .collect(Collectors.toList());