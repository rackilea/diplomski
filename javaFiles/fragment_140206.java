Map<String, SomeOtherPersonType> someOtherPersonTypeMap = somePersonTypeMap.entrySet()
            .stream()
            .collect(Collectors.toMap(
                    Map.Entry::getKey,
                    entry -> SomeOtherPersonType.builder()
                                .fromSomePersonType(entry.getValue())
                                .build()
            ));