FragmentManager fm = getSupportFragmentManager();//if using support lib
Fragment fragment = fm.findFragmentById(R.id.your_container);
if (fragment == null) {
   fragment = YourFragment.newInstance();
   fm.beginTransaction()
   .add(R.id.your_container, fragment, "some_tag_if_you_wish_to_use_find_by_tag_later")
   .commit();
}