public void switchContent(Fragment fragment) {
if(mContent !=null && (fragment.getClass().toString().equals(mContent.getClass().toString()))){
return;
}
    mContent = fragment;

    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction ft = fragmentManager.beginTransaction();
    ft.add(R.id.content_frame, mContent);
    FragmentChangeActivity.fragmentStack.lastElement().onPause();
    FragmentChangeActivity.fragmentStack.push(mContent);
    ft.commit();

    getSlidingMenu().showContent();
}