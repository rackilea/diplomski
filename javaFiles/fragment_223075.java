FragmentManager manager = getSupportFragmentManager();

fragment = manager.findFragmentByTag(str_SomeID);

if (fragment != null && !fragment.isHidden()){

manager.beginTransaction().hide(fragment).commit();
}