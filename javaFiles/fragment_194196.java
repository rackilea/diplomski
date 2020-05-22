Large_Monsters fragment = new Large_Monsters();

if (fragment != null) {
    FragmentManager fragmentMgmt = getSupportFragmentManager();
    fragmentMgmt.beginTransaction().replace(R.id.content_frame, fragment).commit();
}