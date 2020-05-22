Map<String, SomeOtherPersonType> someOtherPersonTypeMap = somePersonTypeMap.entrySet()
            .stream()
            .collect(Collectors.toMap(
                    Map.Entry::getKey,
                    entry -> {
                        final SomePersonType somePersonType = entry.getValue();
                        return SomeOtherPersonType.builder()
                                .name(somePersonType.getName())
                                .age(somePersonType.getAge())
                                .build();
                    }
            ));