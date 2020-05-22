Bundle bundle = new Bundle();
bundle.putString("selectedSpinnerItemKey", selectedSpinnerItemValue);

Fragment fragment = YourFragment.newInstance();
fragment.setArguments(bundle);

FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
transaction.replace(R.id.fragmentContent, fragment);
transaction.commit();