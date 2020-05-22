public class View extends AppCompatActivity implements ViewContract.requiredMethods, MyHandlers{

    ViewModel mModel;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Setting the layout
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mModel=new ViewModel(getContext());
        binding.setUser(mModel);
        binding.setHandlers(this);

    }        

    @Override
    public void onShowToast(View view) {
        Toast.makeText(view,"Clicked",Toast.LENGTH_SHORT).show();
    }
}