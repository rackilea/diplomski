List<Range> ranges = rangesToExclude.stream()
                     .map(Range::new).collect(Collectors.toList());
return directoryRecords.stream()
        .filter((directoryRecord) -> !extensionsToExclude
                                    .contains(directoryRecord.getExtensionNumber()))
        .filter(directoryRecord -> ranges.stream()
                                    .noneMatch(r -> r.isInRange(directoryRecord)))
        .collect(Collectors.toList());