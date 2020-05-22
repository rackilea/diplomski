btnSettings.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        // DO STUFF
        //if button is not selected, change background and tag the View as selected
        if(v.getTag() == null || v.getTag().equals("not_selected")) {
            v.setBackgroundColor(Color.RED);
            v.setTag("selected");
            //show sub-menu
        }
        //if button is already selected, reset background and tag the View as not selected
        else{
            v.setBackgroundResource(android.R.drawable.btn_default);
            v.setTag("not_selected");
            //hide sub menu
        }

    }
});