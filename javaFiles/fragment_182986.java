public class TabsPagerAdapter extends FragmentPagerAdapter {

    // hosted fragments
    private FragmentPage fragmentPageBasic;
    private FragmentPage fragmentPageAdvanced;
    private FragmentPage fragmentPageSettings;

    //constructor
    public TabsPagerAdapter(FragmentManager fm, MainActivity mainActivity){
        super(fm);

        fragmentPageBasic = new FragmentPage();
        fragmentPageBasic.setMainActivity(mainActivity);
        fragmentPageBasic.setLayoutResource(R.layout.fragment_page1);
        fragmentPageBasic.setAdBannerResource(R.id.adBannerBasic);
        fragmentPageBasic.setAdBannerLayoutResource(R.id.adBannerBasicLayout);

        fragmentPageAdvanced = new FragmentPage();
        fragmentPageAdvanced.setMainActivity(mainActivity);
        fragmentPageAdvanced.setLayoutResource(R.layout.fragment_page2);
        fragmentPageAdvanced.setAdBannerResource(R.id.adBannerAdvanced);
        fragmentPageAdvanced.setAdBannerLayoutResource(R.id.adBannerAdvancedLayout);

        fragmentPageSettings = new FragmentSettingsPage();
        fragmentPageSettings.setMainActivity(mainActivity);
        fragmentPageSettings.setLayoutResource(R.layout.fragment_page3);
        fragmentPageSettings.setAdBannerResource(R.id.adBannerSettings);
        fragmentPageSettings.setAdBannerLayoutResource(R.id.adBannerSettingsLayout);
    }

    // page index, fragment selector
    @Override
    public Fragment getItem(int index) {

        switch (index)
        {
            case 0: return fragmentPageBasic;
            case 1: return fragmentPageAdvanced;
            case 2: return fragmentPageSettings;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    // GETTERS
    public FragmentPage getFragmentPageBasic() {return fragmentPageBasic;}
    public FragmentPage getFragmentPageAdvanced() {return fragmentPageAdvanced;}
    public FragmentPage getFragmentPageSettings() {return fragmentPageSettings;}

}