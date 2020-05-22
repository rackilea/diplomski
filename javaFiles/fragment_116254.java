FragmentManager fm = this.getFragmentManager();
GluehweinMapFragment f1 = (GluehweinMapFragment)fm.getFragments().get(0); // to get one fragment

for (Fragment f : fm.getFragments()) { // to loop through fragments and checking their type
    if (f instanceof GluehweinMapFragment) {
    }
}