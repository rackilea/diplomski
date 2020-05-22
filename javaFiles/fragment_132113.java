@Override
public Fragment getItem(int position) {
    // getItem is called to instantiate the fragment for the given page.
    // Return a DummySectionFragment (defined as a static inner class
    // below) with the page number as its lone argument.
    Fragment fragment;
    switch (position) {

    case 0:
        fragment = new encountersFragment();
        break;
    case 1:
        fragment = new patient_chartFragment();
        break;
    case 2:
        fragment = new billingFragment();
        break;
    case 3:
        fragment = new medicationsFragment();
        break;
    case 4:
        fragment = new treatmentsFragment();
        break;
    case 5:
        fragment = new laboratoryFragment();
        break;
    case 6:
        fragment = new imagingFragment();
        break;
    case 7:
        fragment = new doctors_notesFragment();
        break;
    case 8:
        fragment = new departmentsFragment();
        break;
    default:
        break;
    }

    return fragment;
}