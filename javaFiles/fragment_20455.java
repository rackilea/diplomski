@Override
public boolean onOptionsItemSelected(MenuItem item) {
switch (item.getItemId()) {
...
case android.R.id.home:
    switch(currentFragment){
    case FRAGMENT1:
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction
        .replace(R.id.fragment_container, fragment2);
        transaction.commit();
        currentFragment = FRAGMENT_2;
        return true;

    default:
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction
        .replace(R.id.fragment_container, fragment1);
        transaction.commit();
        currentFragment = FRAGMENT_1;
        return true;
    }
}