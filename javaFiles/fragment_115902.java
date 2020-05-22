public static CrimeFragment newInstance(UUID crimeId){

    Bundle args = new Bundle();
    args.putSerializable(EXTRA_CRIME_ID, crimeId);

    CrimeFragment fragment = new CrimeFragment();
    fragment.setArguments(args);

    //pass UUID from extra
    return fragment;
}