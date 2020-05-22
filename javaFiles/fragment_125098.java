FragmentTransaction ft = fm.beginTransaction();
    lf = new LoginFragment();
    ft.replace(R.id.mainContainer, lf); <-----
    ft.addToBackStack(null);
    ft.commit();
}
@Override
public void onLogIn(String sessionID) {
    FragmentTransaction ft = fm.beginTransaction();
    MapScreenFragment mapFrag = new MapScreenFragment();
    ft.replace(R.id.loginpage, mapFrag); <------ change to R.id.mainContainer
    ft.addToBackStack(null);
    ft.commit();
}