private List<Code> get(String qualifier, ZonedDateTime validAt) {
    return em.createQuery(
              "select c\n"
            + "  from Code c\n"
            + " where c.qualifier = :qualifier\n"
            + "   and c.validFrom <= :validAt\n"
            + "   and c.validUntil > :validAt\n"
            + " order by c.sequence, c.code\n",
            com.service.code.impl.model.Code.class)
        .setParameter("qualifier", qualifier)
        .setParameter("validAt", validAt)
        .getResultList().stream()
        .map(converter::convert)
        .collect(Collectors.toList());
}