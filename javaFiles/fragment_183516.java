public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view =  inflater.inflate(R.layout.fragment_41, container, false);

    TextView textViewDisplayResult = (TextView) view.findViewById(R.id.text_view_display_result);
    textViewDisplayResult.setText(getActivity().getIntent().getBooleanExtra("Key Answer", false)?R.string.Good_answer:R.string.Wrong_answer);

    return view;
}