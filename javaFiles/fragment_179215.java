if (id == R.id.nav_dict){

        String activeFragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container).getClass().getSimpleName();
        if (!activeFragment.equals(DictionaryFragment.class.getSimpleName())){

            goToFragment(dictionaryFragment, false);
        }
    }