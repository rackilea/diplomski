public class Informazioni extends Fragment {

    TextView textView;
    View view;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)            
    {
        view = inflater.inflate(R.layout.home_page, container, false);
        textView = (TextView) view.findViewById(R.id.textView1);
        textView.setText("welcome");
        return view;
    }

}