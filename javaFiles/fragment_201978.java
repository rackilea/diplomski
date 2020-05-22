@Override 
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        initUIobjects(view);
    }

    private void initUIobjects(View view){
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.view_pager);
    //... and so on
    }