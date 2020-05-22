String getFragmentTagByIndex(final int index) {
    switch (index) {
       // Make return tag.
    }
}

{
// inside switchFragment
    final Fragment visibleFragment = transaction.findFragmentByTag(getFragmentTagByIndex(selected));
    transaction.hide(visibleFragment);
}