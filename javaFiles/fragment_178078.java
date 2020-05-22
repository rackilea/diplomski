Fragment fragment = new aboutSLFragment();
 FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
 FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
 fragmentTransaction.replace(R.id.home, fragment);
 fragmentTransaction.addToBackStack(null);
 fragmentTransaction.commit();