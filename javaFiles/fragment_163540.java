List<Admin> admin = subProducers.stream()
        .filter(a -> a.getAdminSitCodes().stream()
                .map(new SitCodeMap())
                .map(Pair::getFirst) // assuming this is Stream<String>
                .distinct()
                .anyMatch(values::contains))
        .collect(Collectors.toList());