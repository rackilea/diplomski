public class animal_tab1 extends Fragment {

    Button AddDiseases, ViewData;
    EditText name, laxan, upay, news;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Get the view from fragmenttab1.xml
        View view = inflater.inflate(R.layout.animal_tab1, container, false);


        Button AddDiseases = (Button) view.findViewById(R.id.btnAdd);
        Button ViewData = (Button) view.findViewById(R.id.btnView);

    name = (EditText) view.findViewById(R.id.ed_name);
    laxan = (EditText)view.findViewById(R.id.ed_laxan);
    upay = (EditText)view.findViewById(R.id.ed_upay);
    news = (EditText)view.findViewById(R.id.ed_News);
   }
}