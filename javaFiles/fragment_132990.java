public void onClick(View v) {
    float b;
    if(v.getId()==R.id.button1){
        float a = Float.valueOf(t1.getText().toString()); 
        b=a*1024;
        t2.setText(" "+b,TextView.BufferType.EDITABLE);
    }
}