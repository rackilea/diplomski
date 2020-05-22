private String buildSearchQueryFrom(final String selectStatement, final String maybePartialUsername,
      final String maybePartialRuleName) {
    final Collection<String> searchFilters = Lists.newArrayListWithCapacity(2);

    if (shouldFilterSearchBy(maybePartialUsername)) {
      searchFilters.add("users.username like :maybePartialUsername");
    }

    if (shouldFilterSearchBy(maybePartialRuleName)) {
      searchFilters.add("rules.ruleName like :maybePartialRuleName");
    }

    final String whereClauseParts = Joiner.on(" and ").skipNulls().join(searchFilters);
    return Joiner.on(" where ").skipNulls().join(selectStatement, whereClauseParts);
  }