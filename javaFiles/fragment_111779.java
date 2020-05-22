public static PlaceholderFragment newInstance(int sectionNumber, int drawableId) {
    PlaceholderFragment fragment = new PlaceholderFragment();
    Bundle args = new Bundle();
    args.putInt(ARG_SECTION_NUMBER, sectionNumber);
    args.putInt(ARG_DRAWABLE_ID, drawableId);
    fragment.setArguments(args);
    return fragment;
}

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    ...
    ImageView levelImage = (ImageView) rootView.findViewById(R.id.imageView3);
    levelImage.setImageResource(getArguments().getInt(ARG_DRAWABLE_ID));

    return rootView;
}