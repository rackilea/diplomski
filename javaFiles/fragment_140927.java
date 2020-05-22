EditText yardarea , brick , rcc,  overhead , underground;

public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    yardarea = (EditText)view.findViewById(R.id.yardarea);
     brick = (EditText)view.findViewById(R.id.brick);
    rcc = (EditText)view.findViewById(R.id.rcc);
    overhead = (EditText)view.findViewById(R.id.overhead);
    underground = (EditText)view.findViewById(R.id.underground);

    Button button = (Button) view.findViewById(R.id.register);
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String areaofyard = yardarea.getText().toString();
            String brickused = brick.getText().toString();
            String rccused = rcc.getText().toString();
            String ovhh = overhead.getText().toString();
            String ung = underground.getText().toString();

            DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getActivity().getApplicationContext());
            databaseAccess.open();
            databaseAccess.insertIntoCriteriaTable(areaofyard, brickused, rccused, ovhh, ung );
            databaseAccess.close();

        }
    });
}