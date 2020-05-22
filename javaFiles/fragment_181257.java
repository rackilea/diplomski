@Override
public void oBClicked(boolean x){
    FragmentManager fm = getSupportFragmentManager();
    FragmentTransaction ft = fm.beginTransaction();
    Fragment fragment = new TextFragment();

    Bundle arguments = new Bundle();
    arguments.putBoolean("data",x);
    fragment.setArguments(arguments);

    ft.replace(R.id.fragmentContainer, fragment);
    ft.addToBackStack(null);
    ft.commit();
}