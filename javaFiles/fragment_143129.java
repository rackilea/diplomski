public List<ErrorMessage> validate(T value) {
    if(ruleSetModified){
        //be careful: validate becomes unsafe for multithreading here, even if you
        //aren't modifying the ruleset; if this is a problem, implement locking
        //inside here. Multiple threads may try to sort the collection, but not
        //simultaneously. Usually, the set won't be modified, so locking before
        //the test is much, much slower. Synchronizing the method is safest,
        //but carries a tremendous performance penalty
        Collections.sort(rule);
        ruleSetModified = false;
    }
    List <ErrorMessage> errors = new ArrayList<String>();
        PrioritizedRule prev = null;
        for (PrioritizedRule<? super T> rule : tests) {
            if(prev != null && prev.compareTo(rule) != 0 && !errors.isEmpty()){
                return errors;
            }
            errors.addAll(rule.check(value));
            prev = rule;
        }
        return errors;
}