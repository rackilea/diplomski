Set<String> imageIdsSet = new HashSet<>(IDsFromImage);

List<String> overlappingIds = IDsFromFile.stream()
    .filter(imageIdsSet::contains)
    .collect(toList());

// OR

Map<Boolean, List<String>> partitionedIds = IDsFromFile.stream()
    .collect(partitioningBy(imageIdsSet::contains));
List<String> overlappingIds = partitionedIds.get(true);
List<String> missingIds = partitionedIds.get(false);