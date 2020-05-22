View view =  inflater.inflate(R.layout.fragment_crime, container, false);
try {
Button submit = (Button) view.findViewById(R.id.submitButton);
EditText id = (EditText) view.findViewById(R.id.crimeID);
EditText des = (EditText) view.findViewById(R.id.crimeDesc);

submit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Toast.makeText(view.getContext(), "Cant save yet!", Toast.LENGTH_SHORT).show();

        Crime crime = new Crime();

        String desS = des.getText().toString();
        String idS = (id.getText().toString());
        if(desS == null || idS == null){
            Toast.makeText(getContext(),"Blank fields !",Toast.LENGTH_SHORT).show();
            return;
        }
        crime.setId(Integer.parseInt(desS));
        crime.setDesc(desS);
        addCrime(crime);
    }
});