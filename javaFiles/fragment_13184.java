@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // .....
        setupDrawerToggle();
        // here you need call selectItem() method 
        selectItem(0) // you can change default fragment by changing parameter (0/1/2) as you want
    }