class MyAdapter extends FragmentPagerAdapter{

    // Three simple fragments
    BaseFragment fragA;
    BaseFragment fragB;
    BaseFragment fragC;

    public MyAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setFragments(Context c){

        // Set up the simple base fragments
        fragA = new BaseFragment();
        fragB = new BaseFragment();
        fragC = new BaseFragment();

        Resources res = c.getResources();

        fragA.changeText("This is Fragment A!");
        fragB.changeText("This is Fragment B!");
        fragC.changeText("This is Fragment C!");

        fragA.changeBG(res.getColor(R.color.dev_blue));
        fragB.changeBG(res.getColor(R.color.dev_green));
        fragC.changeBG(res.getColor(R.color.dev_orange));

    }

    @Override
    public Fragment getItem(int position) {
        // TODO: Make this more efficient, use a list or such, also comment more
        Fragment frag = null;
        if(position == 0){
            frag = fragA;
        }
        else if(position == 1){
            frag = fragB;
        }
        else if(position == 2){
            frag = fragC;
        }

        return frag;
    }

    @Override
    public int getCount() {
        return 3;
    }
}