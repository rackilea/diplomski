public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) 
{

    View view = inflater.inflate(R.layout.results_fragment, container, false);

    r = (TextView) view.findViewById(R.id.resultsTV);
    r.setText(MainActivity.myResultString);
    return view;
}