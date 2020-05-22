ItemDetailFragment itemDetailFragment=new ItemDetailFragment();

      FragmentTransaction transaction = 
  getFragmentManager().beginTransaction();

transaction.setCustomAnimations(animSlideIn, animSlideOut, animSlideIn, animSlideOut);
transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).replace(R.id.frameLayout, itemDetailFragment)
        .commitAllowingStateLoss();`