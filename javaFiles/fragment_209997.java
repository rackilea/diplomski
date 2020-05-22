public void removeFragmentbyTag(String myFrag){

 FragmentManager manager = getActivity().getSupportFragmentManager();
 FragmentTransaction trans = manager.beginTransaction();
 trans.remove(myFrag);
 trans.commit();
 manager.popBackStack();
}