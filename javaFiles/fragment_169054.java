Set<Integer> accountIds = Set.of(1, 2, 5);
List<Account> result = accounts.stream()
        .filter(a -> accountIds.contains(a.getId()))
        .collect(Collectors.groupingBy(Account::getId, Collectors.groupingBy(Account::getDate, TreeMap::new, Collectors.toList())))
        .values().stream()
        .flatMap(m -> m.lastEntry().getValue().stream())
        .collect(Collectors.toList());