@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
    Bundle savedInstanceState) {
  View rootView = inflater.inflate(R.layout.fragment_main, container,
      false);

  View something = rootView.findViewById(R.id.something); // not activity findViewById()
  something.setOnClickListener(new View.OnClickListener() { ... });

  return rootView;
}