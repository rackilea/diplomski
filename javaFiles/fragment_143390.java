Fragment[] tabFragments = new Fragment[] {CalendarFragment.newInstance(), 
                                           FeedFragment.newInstance()}

.....

@Override
public Fragment getItem(int position) {
    return tabFragments[position];
}