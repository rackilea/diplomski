@Override
public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    Bundle bundle = getArguments();
    ((ImageView)view.findViewById(R.id.imageView)).setImageResource(bundle.getInt(BUNDLE_DRAWABLE_KEY));
    ((TextView)view.findViewById(R.id.textView)).setText(bundle.getString(BUNDLE_STRING_KEY));
    ((TextView)view.findViewById(R.id.textViewdesc)).setText(bundle.getString(BUNDLE_STRING_DESC_KEY));
}