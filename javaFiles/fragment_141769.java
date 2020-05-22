public class DogValidationStrategy implements ValidationStrategy<Dog> {
    public List<Rule<? super Dog>> getRules() {
        List<Rule<? super Dog>> rules = new ArrayList<Rule<? super Dog>>();
        rules.add(new Rule<Dog>() {
            public List<ValidationError> check(Dog dog) {
                // dog check...
                return Collections.emptyList();
            }
        });
        rules.add(new Rule<Animal>() {
            public List<ValidationError> check(Animal animal) {
                // animal check...
                return Collections.emptyList();
            }
        });
        return rules;
    }
}