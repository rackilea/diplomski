mFragment = new AddFragment();

FragmentManager fragmentManager = getSupportFragmentManager();
FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
fragmentTransaction.replace(android.R.id.content, mFragment);
fragmentTransaction.commit();