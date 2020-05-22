public class AChoice extends AAbstract {
    private AChoice() {
        Context.duplicate();
    }

    public static AChoice create() {
        return new AChoice();
    }

    @Override
    public AChoice choice(ChoiceList choices) {
        super.choice(choices);
        return this;
    }

    @Override
    public AChoice execute() {
        super.execute();
        return this;
    }
}