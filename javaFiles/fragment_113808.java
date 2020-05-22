@Override
public <ENTITY> Predicate getEndPredicate(
    CriteriaBuilder criteriaBuilder,
    final Root<ENTITY> data,
    final EntityType<ENTITY> entityType,
    final LocalDate endDate)
{
    return criteriaBuilder.greaterThanOrEqualTo( 
        data.get(entityType.getSingularAttribute(dateAttribute, LocalDate.class)),
        criteriaBuilder.literal(endDate)));
}