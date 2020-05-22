FragmentManager fm = getSupportFragmentManager();
FragmentTransaction ft = fm.beginTransaction();
Fragment newFragment = fm.findFragmentByTag("Some_Tag");
if (newFragment == null) {
     newFragment = SomeFragment.newInstance(); //create a new frag
}
// Find the old one to know if we have to replace or simply add to this container
Fragment oldFragment = fm.findFragmentById(R.id.content_container);
if (oldFragment != null) {
    ft.replace(R.id.content_container, newFragment, "Some_Tag");
} else {
    ft.add(R.id.content_container, newFragment, "Some_Tag");
}
// optionally use a nice transition
ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
// …and to the backstack if you wish…
ft.addToBackStack(null).commit();