private static final String TAG_PLACEHOLDER = "placeholder";

FragmentManager fm = getSupportFragmentManager();
placeholderFragment = (DataLoaderFragment)fm.findFragmentByTag(TAG_PLACEHOLDER);
if (placeholderFragment == null) {
    placeholderFragment = PlaceholderFragment.newInstance(sectionNumber);
    fm.beginTransaction().add(placeholderFragment, TAG_PLACEHOLDER).commit();
}
// you have the reference to fragment from calling newInstance(sectionNumber) or findFragmentByTag, so you can execute the method:
placeholderFragment.setItem();