public class SectionsPagerAdapter extends FragmentStatePagerAdapter {
   private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();

    public SectionsPagerAdapter(FragmentManager fm) {
    super(fm);
    }

   @Override
   public Fragment getItem(int position) {
    return mFragmentList.get(position);
   }

@Override
public int getCount() {
    return mFragmentList.size();
}

public void addFrag(Fragment fragment, String title) {
    mFragmentList.add(fragment);
    mFragmentTitleList.add(title);
}

@Override
public CharSequence getPageTitle(int position) {

    return mFragmentTitleList.get(position);
    }

 }