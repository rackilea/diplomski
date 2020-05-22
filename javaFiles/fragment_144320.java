Button btplus = (Button)findViewById(R.id.button1);  
    btplus.setOnClickListener(new View.OnClickListener(){
    @Override
    public void onClick(View v)
    {
        double tf3;
        double tf1 =Double.parseDouble(ed1.getText().toString());
        double tf2 =Double.parseDouble(ed2.getText().toString());
        tf3 = tf1 + tf2; 
        result.setText(String.valueOf(tf3));
    }
    });