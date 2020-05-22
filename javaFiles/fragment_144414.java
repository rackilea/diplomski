public class SecondFragment extends Fragment {

     public SecondFragment() {
    // Required empty public constructor
}

  @Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.second_fragment, container, false);
    TextView textView = (TextView)view.findViewById(R.id.textView);
    view.setBackgroundColor(Color.WHITE);
    String key = getArguments().getString("Key");
    //Set the value to your text view
     textView.setText(key);
    return view;
}