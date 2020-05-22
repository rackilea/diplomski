public static class PlaceholderFragment extends Fragment {

    public PlaceholderFragment (){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);

        Button but1 = (Button)getActivity(). findViewById(R.id.b1);
        TextView tv1 = (TextView)getActivity(). findViewById(R.id.tv1);

        but1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                tv1.setText("Button pressed");

            }
        });
    }
}