@Nullable
@Override
public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    checkMListener();

    FragmentToolbarBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_toolbar, container, false);

    // FIXME you're losing data here; watch out: checking whether savedInstanceState == null is not enough because returning from backstack it will be null
    modelData = ToolbarBind.newInstance();

    // FIXME modify this so it sets the data from savedInstanceState when configuration changes
    modelData.searchedText.set("Hello");


    binding.setModelData(modelData);

    //get button to set onClick event
    binding.btnSearch.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String hello = modelData.searchedText.get();
        }
    });

    return binding.getRoot();
}