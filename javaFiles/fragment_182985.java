public class TabsPagerAdapter extends FragmentPagerAdapter {    

    public TabsPagerAdapter(FragmentManager fm, MainActivity mainActivity){
        super(fm);
    }

    // page index, fragment selector
    @Override
    public Fragment getItem(int index) {

        switch (index)
        {
            case 0: return new FragmentPage1(); // bad practice
            case 1: return new FragmentPage2(); // why should one do that?
            case 2: return new FragmentPage3(); 
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}