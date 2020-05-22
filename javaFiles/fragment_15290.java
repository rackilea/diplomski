public class PagerAdapter extends FragmentPagerAdapter {
    String nameString;
    public PagerAdapter(FragmentManager fm, String nameString) {
        super(fm);
        this.nameString = nameString;
    }
    @Override
public Fragment getItem(int position) {
    switch (position){
        case 0:
            ProfileActivity profileActivity=new ProfileActivity();
            Bundle bundle=new Bundle();
            bundle.putString("NAME",nameString);
            profileActivity.setArguments(bundle);
            return profileActivity;
        case 1:
            FollowersActivity followersActivity=new FollowersActivity();
            return followersActivity;
        case 2:
            PublicRepos publicRepos=new PublicRepos();
            return publicRepos;

        default:
            return null;
    }
}

@Override
public int getCount() {
    // Show 3 total pages.
    return 3;
}

@Override
public CharSequence getPageTitle(int position) {
    switch (position) {
        case 0:
            return "Profile Info";
        case 1:
            return "Followers";
        case 2:
            return "Public Repos";
    }
    return null;
   }
}