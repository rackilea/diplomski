//Fragment Changer
    public void changeFragment(Fragment targetfragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_fragment, targetfragment, "fragment")
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .addToBackStack(null)
                .commitAllowingStateLoss();
    }