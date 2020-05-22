public void onDestroyView() 
 {
    super.onDestroyView(); 
    Fragment fragment = (getFragmentManager().findFragmentById(R.id.map));  
    FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
    ft.remove(fragment);
    ft.commit();
}