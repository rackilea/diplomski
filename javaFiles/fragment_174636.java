CategoryFragment newFragment = CategoryFragment.newInstance(categoryIdSelected);
FragmentTransaction transaction = getFragmentManager().beginTransaction();

transaction.replace(R.id.fragment_container, newFragment);
transaction.addToBackStack(null);

transaction.commit();