public void fillfive(View v) {
    TextView textViewA = (TextView) findViewById(R.id.the_text_view_you_want_to_check);
    TextView textViewB = (TextView) findViewById(R.id.txt_fivecup);     

    if (textViewA.getText().toString().equals("0")){
        textViewB.setText("5");
    }
    else{
        textViewB.setText("0");
    }
}