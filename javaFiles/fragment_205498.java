//to get data from text view of first layout use the following code
LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
View vi = inflater.inflate(R.layout.layout1, null);

TextView tv1 = (TextView) vi.findViewById(R.id.textview1);
// to set of first textview in second textview
textview2.setText(tv1.getText().toString