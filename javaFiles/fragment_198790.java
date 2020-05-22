private void drawFragmentFromId(int id)
{
    android.app.Fragment currentFragment = fm.findFragmentById(R.id.mainFrame);
    if (id == R.id.nav_overview)
    {
        //fm is a global fragment manager, is that bad practice?
        if(currentFragment.getTag() == "F_SETTINGS"){
//-------------------------------------------------------------------------------
            fm.popBackStack(); //it was this guy here. that's all I was missing.
//-------------------------------------------------------------------------------
            fm.beginTransaction().replace(currentFragment.getId(), oFrag, "F_OVERVIEW").commit();
        }
        else
            fm.beginTransaction().replace(currentFragment.getId(), oFrag, "F_OVERVIEW").addToBackStack(currentFragment.getTag()).commit();
    }
....
}