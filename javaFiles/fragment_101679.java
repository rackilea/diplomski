private List<UserEntity> getRevisions(Number revisionNumber) {
    final AuditReader auditReader = AuditReaderFactory.get(this.em);
    try {
        return auditReader.createQuery().forRevisionsOfEntity(UserEntity.class, true, false)
                .add(AuditEntity.revisionNumber().maximize().computeAggregationInInstanceContext().add(AuditEntity.revisionNumber().le(revisionNumber)))
                .getResultList();
    } catch (final NoResultException e) {
        return null;
    }
}