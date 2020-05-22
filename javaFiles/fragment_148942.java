class OrderCriteriaGroup {
    final Set<Long> procedures = new HashSet<>();
    final Set<Long> diagnoses = new HashSet<>();

    void add(OrderCriteria o) {
        procedures.add(o.getProcedureId());
        diagnoses.add(o.getDiagnosisId());
    }

    OrderCriteriaGroup merge(OrderCriteriaGroup g) {
        procedures.addAll(g.procedures);
        diagnoses.addAll(g.diagnoses);
        return this;
    }
}