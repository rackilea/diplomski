b_start.setOnClickListener( new View.OnClickListener() {
    public void onClick(View v) {
        final int status =(Integer) v.getTag();
        if(status == 1) {
            b_start.setText("Stop");
            v.setTag(0); 
        } else {
            b_start.setText("Start");
            v.setTag(1); 
        }
    }
});