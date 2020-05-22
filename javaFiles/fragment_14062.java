public class TerminalService {

  private static Specification<Terminal> hasProperties(final Map<String, String> properties) {
    return new Specification<Terminal>() {
      @Override
      public Predicate toPredicate(Root<Terminal> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        // SELECT TERMINAL_FK FROM TERMINAL_PROPERTIES
        Subquery<TerminalProperty> subQuery = query.subquery(TerminalProperty.class);
        Root propertyRoot = subQuery.from(TerminalProperty.class);
        subQuery.select(propertyRoot.get("terminal.id"));
        Predicate whereClause = null;
        for (Map.Entry<String, String> entry : properties.entrySet()) {
          // (KEY = 'key1' AND VALUE = 'value1')
          Predicate predicate = builder.and(builder.equal(propertyRoot.get("key"),
              entry.getKey()), builder.equal(propertyRoot.get("value"), entry.getValue()));
          if (whereClause == null) {
            whereClause = predicate;
          } else {
            // (...) OR (...)
            whereClause = builder.or(whereClause, predicate);
          }
        }
        subQuery.where(whereClause);
        // GROUP BY TERMINAL_FK
        subQuery.groupBy(propertyRoot.get("terminal.id"));
        // HAVING COUNT(*) = 42
        subQuery.having(builder.equal(builder.count(propertyRoot), properties.size()));

        // WHERE ID IN (...)
        return query.where(builder.in(root.get("id")).value(subQuery)).getRestriction();
      }
    };
  }

  @Autowired
  private TerminalRepository terminalRepository;

  public Iterable<Terminal> findTerminalsWith(Map<String, String> properties) {
    // this works only because our repository implements JpaSpecificationExecutor
    return terminalRepository.findAll(hasProperties(properties));
  }
}