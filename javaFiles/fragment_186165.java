@Override
    public Fragment getItem(int position) {

        Fragment fragment = new DummySectionFragment();
        Bundle args = new Bundle();
        args.putString("key",myTextView.getText().toString());
        args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, position + 1);
        fragment.setArguments(args);
        return fragment;
    }