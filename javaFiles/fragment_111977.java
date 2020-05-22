FragmentManager fm = getFragmentManager();
FragmentTransaction ft = fm.beginTransaction();

TextFragment tf = new TextFragment();
ft.replace(R.id.container, tf);
ft.commit();