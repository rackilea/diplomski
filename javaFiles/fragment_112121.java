public abstract class BaseActivityClass extends Activity {
    private final int mContentLayoutId;
    protected BaseActivityClass(int contentLayoutId) {
        mContentLayoutId = contentLayoutId;
    }

    protected void onCreate(Bundle state) {
        // Same code to load ViewStub, but use mContentLayoutId instead
    }
}

public SomeOtherActivity extends BaseActivity {
    public SomeOtherActivity() {
        super(R.layout.SomeOtherLayout); // Call super with derived layout
    }
}