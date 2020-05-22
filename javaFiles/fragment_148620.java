@Override
public Fragment getItem(int position) {
    ItemViewerFragment fragment = ItemViewerFragment.newInstance(mItems.get(position));
    mFragments.put(position,fragment);
    return fragment;
}