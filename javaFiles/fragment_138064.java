public class CustomerHeaderParameterSpecification implements Specification<CustomerHeaderParameter> {

    private StatusCode status;
    private CustomerType customerType;
    private SegmentParmNumber segment;
    private ModuleType module;
    private CardType cardType;
    private ProcessType processType;
    private RewardType rewardType;
    private Integer min, max;


    public CustomerHeaderParameterSpecification(StatusCode status, CustomerType customerType, SegmentParmNumber segment, ModuleType module, CardType cardType, ProcessType processType, RewardType rewardType, Integer min, Integer max) {
          this.status = status;
          this.customerType = customerType;
          this.segment = segment;
          this.module = module;
          this.cardType = cardType;
          this.processType = processType;
          this.rewardType = rewardType;
          this.min = min;
          this.max = max;
    }

    @Override
    public Predicate toPredicate(Root<CustomerHeaderParameter> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

        List<Predicate> predicates = new ArrayList<>();
        if (this.status != null) predicates.add(criteriaBuilder.equal(root.get(STATUS_CODE), status));
        if (this.customerType != null) predicates.add(criteriaBuilder.equal(root.get(CUSTOMER_TYPE), customerType));
        if (this.segment != null) predicates.add(criteriaBuilder.equal(root.get(SEGMENT_PARM_NUMBER), segment));
        if (this.module != null) predicates.add(criteriaBuilder.equal(root.get(MODULE_TYPE), module));
        if (this.cardType != null) predicates.add(criteriaBuilder.equal(root.get(CARD_TYPE), cardType));
        if (this.processType != null) predicates.add(criteriaBuilder.equal(root.get(PROCESS_TYPE), processType));
        if (this.rewardType != null) predicates.add(criteriaBuilder.equal(root.get(REWARD_TYPE), rewardType));
        if (this.min != null && this.max != null) predicates.add(criteriaBuilder.between(root.get(PARAMETER_NUM), min, max));

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }

}