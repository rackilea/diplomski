public static class PlaceholderFragment extends Fragment {

    public PlaceholderFragment() {
    }

    int counter=0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container,
            false);

        Button add = (Button) rootView.findViewById(R.id.bAdd);
        Button sub = (Button) rootView.findViewById(R.id.bSub);
        TextView display = (TextView) rootView.findViewById(R.id.tvDisplay);

        add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                counter++;
                display.setText("Counter equals" + counter);
            }
        });

        return rootView;
    }
}