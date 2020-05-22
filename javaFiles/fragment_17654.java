public List<UserEntity> search(final String maybePartialUsername, final String maybePartialRuleName)
      throws EntityException {
    final String selectUsersStatement = "select distinct users from UserEntity as users";
    final String joinUsersWithRulesClause = shouldFilterSearchBy(maybePartialRuleName) ? "inner join users.rules as rules" : null;


    return search(Joiner.on(" ").skipNulls().join(selectUsersStatement, joinUsersWithRulesClause),
        maybePartialUsername, maybePartialRuleName);
  }