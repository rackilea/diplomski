public class Person {
    private final List<Integer> choices = new ArrayList<>();

    public Person(Integer... choices) {
        this.choices.addAll(Arrays.asList(choices));
    }

    public List<Integer> getChoices() {
       return choices;
    }

    public int costOf(Integer activity) {
        return choices.indexOf(activity)+1;
    }
}