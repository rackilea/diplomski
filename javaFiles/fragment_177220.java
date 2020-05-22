@Override
public boolean onNavigationItemSelected(int position, long id) {

    switch(position)
    {
        case 0:
        fragment0 = Fragment0.newInstance();
        fragmentManager.beginTransaction().replace(R.id.container, fragment0).commit();
        break;

        case 1:
        fragment1 = Fragment1.newInstance();
        fragmentManager.beginTransaction().replace(R.id.container, fragment1).commit();
        break;

        //etc...
    }

    return true;
}