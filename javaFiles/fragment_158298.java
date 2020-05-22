public abstract class ChildActivity extends BaseActivity {

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState); // Here it calls the parent onCreate method and therefore executes the styling code
    }
}