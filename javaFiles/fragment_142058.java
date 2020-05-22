Fragment fragment = new {your-fragment()};
 FragmentManager fm1 = getActivity().getSupportFragmentManager();
 FragmentTransaction ft1 = fm1.beginTransaction();
 fm1.popBackStack();
 ft1.replace({layout}, fragment).addToBackStack("tag");
 ft1.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
 ft1.commit();