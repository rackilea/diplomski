public void onClick(View v) {
    double b;
    if(v.getId()==R.id.button1){
        double e1 = Double.parseDouble(t1.getText().toString());

        b=a*1024;
        t2.setText(" "+String.valueOf(b),TextView.BufferType.EDITABLE);
    }
}