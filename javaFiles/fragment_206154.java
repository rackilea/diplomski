FragmentManager fragmentManager = getFragmentManager()
FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

Fragment fraggy = new DummyFragment();
fragmentTransaction.add(R.id.fragment_container, fraggy);
fragmentTransaction.commit();