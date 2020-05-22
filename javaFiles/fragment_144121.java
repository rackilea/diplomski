@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.rap_prog_fields, container, false);
    TextView tv = (TextView) v.findViewById(R.id.text_view_1);
    Button b = (Button) v.findViewById(R.id.button);
    b.setOnClickListener(new View.OnClickListener() {
         public void onClick(View v) {
             //do stuff
         }
     });
    //the rest of your views... in the same manner

    return v;
}