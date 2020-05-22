//Create a Universal Listener for all our buttons
OnClickListener listener = new View.OnClickListener() {
    public void onClick(View v) {
        Button b = (Button)v;
        String text = b.getText().toString(); //get the button's name
        if(text.equals("Paul")) {
            //do anything for Paul ONLY in here
        }
    }
});

btn_a.setOnClickListener(listener); //give all the buttons the same listener, but only Paul's listener will do anything when you click on it
btn_b.setOnClickListener(listener);
btn_c.setOnClickListener(listener);