Fragment f;
        f = new FragmentTwo();
        FragmentTransaction ft = getFragmentSupportManager().beginTransaction();
        ft.replace(R.id.main_details_fragment_container, f);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.addToBackStack(null);
        ft.commit();