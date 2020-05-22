public class SomeActivityClass extends BaseActivityClass {
    int layout_id = R.layout.SomeOtherLayout;

    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
    }

    @Override
    @LayoutRes
    public int getContentLayoutId() { return layout_id; }
}