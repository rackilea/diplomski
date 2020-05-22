View view = inflater.inflate(R.layout.bmi_fragment,
        container, false);
EditText age = (EditText) view.findViewById(R.id.editText_age);
EditText weight = (EditText) view.findViewById(R.id.editText_weight);
EditText height = (EditText) view.findViewById(R.id.editText_height);
try {
        int age_value = Integer.parseInt(age.getText().toString());
        int weight_value = Integer.parseInt(weight.getText().toString());
        int height_value = Integer.parseInt(height.getText().toString());
        int calc = (weight_value / ((height_value / 100) * (height_value / 100)));
        TextView dd = (TextView) findViewById(R.id.textView);
        dd.setText(calc+"");
} catch (Exception e){
    //Textfield empty
}