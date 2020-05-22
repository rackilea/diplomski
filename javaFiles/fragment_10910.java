public void setFragment(){

Fragment newFragment;

if(displayFragOne){
newFragment = new MyFragment();
}else if(displayFragTwo){
newFragment = new OtherFragment();
} 

FragmentTransaction ft = getFragmentManager().beginTransaction();
ft.replace(r.id.the_id_of_layout,fragment).addToBackStack(null).commit();
}