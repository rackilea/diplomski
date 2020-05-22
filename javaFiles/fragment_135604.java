Fragment frag1 = getFragmentManager().findFragmentByTag(FRAGMENT_TAG_1);
    Fragment frag2 = getFragmentManager().findFragmentByTag(FRAGMENT_TAG_2);

    //P.S: multiple operations can be done in the same transaction
    FragmentTransaction transaction = getFragmentManager().beginTransaction();
    transaction
            .remove(frag1)
            .remove(frag2)
            .commit();