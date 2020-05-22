public class ExampleFragment {
    public static ExampleFragment newInstance(int exampleInt) {
        ExampleFragment fragment = new ExampleFragment();

        Bundle args = new Bundle();
        args.putInt("exampleInt", exampleInt);
        fragment.setArguments(args);

        return fragment;
    }
}