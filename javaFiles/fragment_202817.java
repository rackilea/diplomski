public class SpinnerWrapper extends WrapperClass {

    private final Spinner spinner ;

    public SpinnerWrapper(Item item, Spinner spinner) {
        super(item, spinner);
        this.spinner = spinner ;
    }

    @Override
    public Observable observableValue() {
        return spinner.valueProperty();
    }
}