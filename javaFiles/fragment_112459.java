public class CustomPagerAdapter extends FragmentStatePagerAdapter {
    private final List<String> tabTitles = new ArrayList<String>() {{
        add("Fragment 1");
        add("Fragment 4");
        add("Fragment 7");
    }};

    private List<Fragment> tabs = new ArrayList<>();

    public CustomPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);

        initializeTabs();
    }

    private void initializeTabs() {
        tabs.add(HostFragment.newInstance(new Fragment1()));
        tabs.add(HostFragment.newInstance(new Fragment4()));
        tabs.add(HostFragment.newInstance(new Fragment7()));
    }

    @Override
    public Fragment getItem(int position) {
        return tabs.get(position);
    }

    @Override
    public int getCount() {
        return tabs.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles.get(position);
    }
}