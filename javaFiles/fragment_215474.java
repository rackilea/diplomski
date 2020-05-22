Map<String, Map<String, Long>> resourcesByCategoryAndGroup = resources.stream()
        .collect(Collectors.groupingBy(
                 Resource::getCategory,
                 Collectors.groupingBy(
                            Resource::getGroup,
                            Collectors.counting())));