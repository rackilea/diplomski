final List<UUID> auditRecordIds = execute("select auditRecord from AuditRecordEntity auditRecord where auditRecord.accessTime = 
(select max(auditRecord2.accessTime) from AuditRecordEntity auditRecord2 where  
auditRecord2.auditRepository = auditRecord.auditRepository)")

Root<AuditRecordEntity> root = criteriaQuery.from(AuditRecordEntity.class);
criteriaQuery.select(root);

List<Predicate> predicates = new ArrayList<Predicate>();
predicates.add(root.get("id").in(auditRecordIds.toArray()));
entitySearchCriteria.addPredicates(predicates);
...