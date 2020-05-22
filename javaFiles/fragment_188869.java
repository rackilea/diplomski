Map<String, Long> processed = zipCodes.stream()
            .collect(Collectors.groupingBy(ZipCode::getCounty, Collectors.counting()
        )                        
    );

    processed.entrySet().stream().forEach(zipCode -> System.out.println(zipCode));