FragmentManager fragmentManager = getFragmentManager();  // or getSupportFragmentManager() if you are using compat lib
FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

FragmentX fragmentX = new FragmentX();
Bundle bundle = new Bundle();
bundle.putInt("idforthevalue", position);
fragmentX.setArguments(bundle);

fragmentTransaction.replace(id_of_container, fragmentX).commit();