public class Tab2Simptomi extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_simptomi, container, false);

        String finalText = getArguments().getString("YOUR_TEXT");

        // Do something with finalText
        TextView yourTextView = (TextView) rootView.findViewById(R.id.your_textview);
        // Show text on TextView
        yourTextView.setText(finalText);

        Toast.makeText(getActivity(), "Final Text: " + finalText, Toast.LENGTH_SHORT).show();

        return rootView;
    }
}