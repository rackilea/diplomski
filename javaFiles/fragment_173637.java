@Override
    public void onTabSelected(Tab tab, FragmentTransaction ft) {
      FragmentManager fm = getFragmentManager(); 
      if(fm.findFragmentByTag(tab.getTag().toString()) == null){
           ft = fm.beginTransaction();
           FragmentContent contentfrag = new FragmentContent();
           ft.add(R.id.framelayout, contentfrag, tab.getTag().toString());
           ft.addToBackStack("BackStack" + tab.getTag().toString());
       }
       else{
           Fragment frag = fm.findFragmentByTag(tab.getTag().toString());
           ft.show(frag);
      }
}

    @Override
public void onTabUnselected(Tab tab, FragmentTransaction ft) {
        Fragment frag = this.getFragmentManager().findFragmentByTag(tab.getTag().toString());
    ft.hide(frag);

}