@Override
 public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    // Inflate the layout for this fragment

    View view = inflater.inflate(R.layout.fragment1, container, false);
    view.setBackgroundColor(Color.WHITE);

     listViewAdapter.SetOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        SecondFragment secondFrag = new SecondFragment();
                        Bundle args = new Bundle();
                        args.putString("Key","some value");

                        secondFrag .setArguments(args);
                        getFragmentManager()
                       .beginTransaction()
                       .replace(R.id.container_view, fragment)
                       .addToBackStack(null)
                       .commit();
                    }
                });
    return view;
}