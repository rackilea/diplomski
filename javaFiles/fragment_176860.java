TreeMap<Timestamp, List<STUP>> timestampListMap =
    rupFeedDC.stream()
             .collect(Collectors.groupingBy(STUP::getTransactionDate,
                                            TreeMap::new,
                                            Collectors.toList()));
Timestamp last = timestampListMap.lastKey();