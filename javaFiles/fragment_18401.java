/**
 * @throws NullPointerException When <code>multiSortMeta</code> or <code>filters</code> argument is null.
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public List<?> getList(int first, int pageSize, List<SortMeta> multiSortMeta, Map<String, String> filters) {
    // ...

    Root<StateTable> root = criteriaQuery.from(entityType);
    Join<StateTable, Country> join = root.join(StateTable_.countryId, JoinType.INNER);

    List<Order> orders = new ArrayList<Order>();

    for (SortMeta sortMeta : multiSortMeta) {
        String[] sortField = sortMeta.getSortField().split("\\.", 2);
        Path<Object> path = sortField.length == 1 ? root.get(sortField[0]) : join.get(sortField[1]);
        orders.add(sortMeta.getSortOrder() == SortOrder.ASCENDING 
            ? criteriaBuilder.asc(path) 
            : criteriaBuilder.desc(path));
    }

    List<Predicate>predicates = new ArrayList<Predicate>();

    for (Entry<String, String> filter : filters.entrySet()) {
        String[] filterField = filter.getKey().split("\\.", 2);
        Path path = filterField.length == 1 ? root.get(filterField[0]): join.get(filterField[1]);
        predicates.add(filter.getValue().matches("[0-9]+") 
            ? criteriaBuilder.equal(path, Long.valueOf(filter.getValue()))
            : criteriaBuilder.like(path, "%" + filter.getValue() + "%"));
    }

    // ...
}