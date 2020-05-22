@Override
public void onNavigationDrawerItemSelected(@NonNull MenuItem item) {
    if (item.isChecked())
        return;

    item.setChecked(true);
    setTitle(item.getTitle());

    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction transaction = fragmentManager.beginTransaction();
    Fragment currentlyShown = fragmentManager.findFragmentByTag(currentlyShownTag);

    Fragment dest;
    switch (item.getItemId()){
        case R.id.nav_lgs:
            dest = fragmentManager.findFragmentByTag(LGSFragment.class.getName());
            if (dest == null) {
                Log.d("TRANSACTION", "instanciating new fragment");
                dest = new LGSFragment();
                currentlyShownTag = LGSFragment.class.getName();
                transaction.add(R.id.contentFrame, dest, LGSFragment.class.getName());
            }
            break;
            ...


    }

    if(currentlyShown != null)
        transaction.hide(currentlyShown);

    transaction.show(dest);
    transaction.commit();
    drawerLayout.closeDrawers();
    return true;
}