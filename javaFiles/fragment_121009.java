@Nullable
 @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

  View rootView = inflater.inflate(R.layout.home, container, false);

 postlist = (ListView)rootView.findViewById(R.id.postList);

  // your allll code
  return rootView;
}