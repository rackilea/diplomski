@Override
public void onTabSelected(Tab tab, FragmentTransaction ignoredFt) {
  FragmentManager fragMgr = ((FragmentActivity) mActivity)
        .getSupportFragmentManager();
  FragmentTransaction ft = fragMgr.beginTransaction();

  // Check if the fragment is already initialized
  if (mFragment == null) {
      // If not, instantiate and add it to the activity
      mFragment = Fragment.instantiate(mActivity, mClass.getName());

      ft.add(android.R.id.content, mFragment, mTag);
  } else {
      // If it exists, simply attach it in order to show it
      ft.attach(mFragment);
  }

  ft.commit();
}

@Override
public void onTabUnselected(Tab tab, FragmentTransaction ignoredFt) {
  FragmentManager fragMgr = ((FragmentActivity) mActivity)
          .getSupportFragmentManager();
  FragmentTransaction ft = fragMgr.beginTransaction();

  // Check if the fragment is already initialized
  if (mFragment == null) {
      // If not, instantiate and add it to the activity
      mFragment = Fragment.instantiate(mActivity, mClass.getName());

      ft.add(android.R.id.content, mFragment, mTag);
  } else {
      // If it exists, simply attach it in order to show it
      ft.detach(mFragment);
  }

  ft.commit();
}