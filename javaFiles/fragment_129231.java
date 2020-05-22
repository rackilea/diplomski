FragmentManager fragmentManager = getFragmentManager();
fragmentManager.beginTransaction().replace(R.id.container, objFragment).commit();

Bundle bundle = new Bundle();
bundle.putString(key, value);
objFragment.setArguments(bundle);