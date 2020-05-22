one.setOnClickListener(new View.OnClickListener() {
    public void onClick(View v) {
        if ( index == 0 ) {
            index++;
            text1.setText("1");
        } else if (index == 1 ) {
            text2.setText("1");
            index++;
        }
    }
});