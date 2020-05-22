@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                     Bundle savedInstanceState) {
 View root = inflater.inflate(R.layout.activity_reading_beginner, container,false);

Button btn1 = (Button) root.findViewById(R.id.alphas);
btn1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
             Intent intent = new Intent(getActivity(),Alphabet.class);
    startActivity(intent);
        }
    });
return root;
}