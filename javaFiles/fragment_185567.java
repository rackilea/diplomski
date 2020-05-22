public class SplitTest implements EntryPoint {

    private static TestUiBinder uiBinder = GWT.create(TestUiBinder.class);

    interface TestUiBinder extends UiBinder<SplitLayoutPanel, SplitTest> {
    }

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
        SplitLayoutPanel outer = uiBinder.createAndBindUi(this);

        RootLayoutPanel.get().add(outer);
    }
}