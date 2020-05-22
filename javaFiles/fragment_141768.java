public class Validator<T> implements Rule<T> {
    private List<Rule<? super T>> tests = new ArrayList<Rule<? super T>>();

    public Validator(ValidationStrategy<T> type) {
        this.tests = type.getRules();
    }

    public void addRule(Rule<? super T> rule) {
        tests.add(rule);
    }

    public List<ValidationError> check(T value) {
        List<ValidationError> list = new ArrayList<ValidationError>();
        for (Rule<? super T> rule : tests) {
            list.addAll(rule.check(value));
        }
        return list;
    }
}