public class ChoiceList {
    private List<AChoice> choices = new ArrayList<>();

    public ChoiceList add(AChoice choice) {
        Context.remove();
        choices.add(choice);
        return this;
    }
}