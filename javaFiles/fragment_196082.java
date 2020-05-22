Optional<Rule> rule = rules.stream().
                       .filter(rule -> rule.getCondition().evaluate(rule, record))
                       .findFirst();
if (rule.isPresent()) {
    Records.emit(collector, outputStreamMapping.get(rule.get().getOutputStream()), 
                 tuple, recordId, record);
    collector.ack(tuple);

    ruleApplied = true;
}