@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
Bundle savedInstanceState) {
      String strtext=getArguments().getString("name");

return inflater.inflate(R.layout.fragment, container, false);
}