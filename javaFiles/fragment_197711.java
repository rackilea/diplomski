@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_calculadora, container, false);
        screen = (TextView) view.findViewById(R.id.txtScreen);
        screen.setText("");

        Button yourButton = (Button)view.findViewById(R.id.yourButtonId);
        yourButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                  onClickNumber(v);
             }
        });
        return view;
}