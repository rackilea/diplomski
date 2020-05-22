View.OnClickListener listener = new View.OnClickListener() {
    public void onClick(View v) {
        Button b = (Button)v;
        if (b.getText().toString().equals(""))
            if (turno == 1) {
                turno = 2;
                b.setText("X");
            } else if (turno == 2) {
                turno = 1;
                b.setText("O");
            }
        n_turni++;
        vincitore();
        b.setEnabled(false);
    }
});

b1.setOnClickListener(listener);
b2.setOnClickListener(listener);    
b3.setOnClickListener(listener);
b4.setOnClickListener(listener);
b5.setOnClickListener(listener);    
b6.setOnClickListener(listener);
b7.setOnClickListener(listener);
b8.setOnClickListener(listener);    
b9.setOnClickListener(listener);