@Override
public void onTabSelected(Tab tab, FragmentTransaction ft) {
     mFragment = Fragment.instantiate(mActivity, mClass.getName());
     ft.replace(android.R.id.content, mFragment, mTag);
}

@Override
public void onTabUnselected(Tab tab, FragmentTransaction ft) {
    if (mFragment != null)
        ft.detach(mFragment);
    }
}