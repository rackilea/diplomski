Specification specification = new Specification<XrayVulnerabilityEntity>() {
    @Override
    public Predicate toPredicate(Root<XrayVulnerabilityEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
    List<Predicate> predicates = new ArrayList<>();
    predicates.add(criteriaBuilder.equal(
        root.join("domainArtifactId").get("id"),root.get("id")));
    predicates.add(criteriaBuilder.and(
       root.get("domainArtifactId").get("domainOrgName"),"domainOrgNameString"));
    return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
    }
};

Pageable page = PageRequest.of(0, 5,new Sort(Sort.Direction.ASC, "id") );


List<XrayVulnerabilityEntity> xrayVulnerabilityEntitylists = xrayVulnerabilityEntityRepo.findAll(specification, page);